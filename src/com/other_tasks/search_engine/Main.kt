package com.other_tasks.search_engine

import java.io.File
import java.util.Scanner

fun main() {
    val invertedIndex = mutableMapOf<String, MutableList<Int>>() // Инвертированный индекс
    val files = mutableListOf<File>() // Список файлов

    val scanner = Scanner(System.`in`)

    while (true) {
        println("Введите 1, чтобы добавить новый файл в базу или 2, чтобы осуществить поиск слов по файлам.")
        val choice = scanner.nextLine()

        when (choice) {
            "1" -> {
                println("Введите путь к файлу:")
                val filePath = scanner.nextLine()
                addFile(filePath, invertedIndex, files)
                println(invertedIndex)
            }
            "2" -> {
                println("Введите слова для поиска, разделенные пробелами:")
                val searchWords = scanner.nextLine().split(" ")
                val result = findDocuments(invertedIndex, searchWords)
                if (result.isNotEmpty()) {
                    println("Документы, содержащие все слова: $result")
                } else {
                    println("Нет документов, содержащих все слова.")
                }
            }
            else -> {
                println("Неверный ввод. Пожалуйста, попробуйте снова.")
            }
        }
    }
}

// Функция для добавления файла
fun addFile(filePath: String, invertedIndex: MutableMap<String, MutableList<Int>>, files: MutableList<File>) {
    val file = File(filePath)

    // Проверяем, существует ли файл
    if (!file.exists() || !file.isFile) {
        println("Файл не найден. Пожалуйста, проверьте путь.")
        return
    }

    // Добавляем файл в список
    files.add(file)

    // Читаем содержимое файла и обновляем инвертированный индекс
    file.forEachLine { line ->
        val words = line.lowercase().split(" ") // Используем регулярное выражение для удаления символов
        for (word in words) {
            val cleanedWord = word.trim() // Удаляем пробелы
            if (cleanedWord.isNotEmpty()) {
                // Обновляем инвертированный индекс
                if (cleanedWord in invertedIndex) {
                    invertedIndex[cleanedWord]!!.add(files.size) // Добавляем индекс файла
                } else {
                    invertedIndex[cleanedWord] = mutableListOf(files.size) // Создаем новый список
                }
            }
        }
    }

    // Сжимаем список индексов с помощью Delta Encoding
    for ((key, value) in invertedIndex) {
        invertedIndex[key] = deltaEncode(value) // Сжимаем список индексов
    }

    println("Файл добавлен: ${file.name}")
}

// Функция для поиска документов
fun findDocuments(invertedIndex: Map<String, List<Int>>, words: List<String>): List<Int> {
    var result: Set<Int> = emptySet()

    for (word in words) {
        val docList = invertedIndex[word.lowercase()] // Ищем слово без учета регистра

        if (docList != null) {
            result = if (result.isEmpty()) {
                decodeDelta(docList).toSet() // Декодируем первый список
            } else {
                intersect(result.toList(), decodeDelta(docList).toList()).toSet() // Находим пересечение
            }
        }
    }

    return result.toList()
}

// Метод для сжатия списка с помощью Delta Encoding
fun deltaEncode(list: List<Int>): MutableList<Int> {
    return if (list.isEmpty()) {
        mutableListOf()
    } else {
        val encoded = mutableListOf(list[0]) // Первое значение сохраняем как есть
        for (i in 1 until list.size) {
            encoded.add(list[i] - list[i - 1]) // Сохраняем разницу
        }
        encoded
    }
}

// Метод для нахождения пересечения с использованием двух указателей и Delta Encoding
fun intersect(list1: List<Int>, list2: List<Int>): List<Int> {
    val intersection = mutableListOf<Int>()
    var i = 0
    var j = 0

    // Алгоритм двух указателей
    while (i < list1.size && j < list2.size) {
        when {
            list1[i] < list2[j] -> i++ // Увеличиваем указатель для первого списка
            list1[i] > list2[j] -> j++ // Увеличиваем указатель для второго списка
            else -> {
                intersection.add(list1[i]) // Найдено пересечение
                i++
                j++
            }
        }
    }

    return intersection
}

// Метод для декодирования списка, закодированного с помощью Delta Encoding
fun decodeDelta(encoded: List<Int>): List<Int> {
    return if (encoded.isEmpty()) {
        emptyList()
    } else {
        val decoded = mutableListOf(encoded[0]) // Первое значение сохраняем как есть
        for (i in 1 until encoded.size) {
            decoded.add(decoded[i - 1] + encoded[i]) // Восстанавливаем исходное значение
        }
        decoded
    }
}
