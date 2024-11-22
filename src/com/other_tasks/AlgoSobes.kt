package com.other_tasks

fun main(){
    val s = readln()
    var left = 0
    var len = 0
    var zeroCount = 0
    var flag = 0
    val zeroIndices = ArrayDeque<Int>() // Хранит индексы символов '0'
    var maxLength = 0

    for (right in s.indices) {
        if (s[right] == '0') {
            zeroIndices.addLast(right) // Добавляем индекс '0' в очередь
            flag = 1
        }

        // Если в окне больше одного '0', сдвигаем левую границу
        if (zeroIndices.size > 1) {
            left = zeroIndices.removeFirst() + 1 // Удаляем старый '0' из очереди и обновляем left
        }

        maxLength = maxOf(maxLength, right - left + 1)
    }

    if (flag == 0){
        len--
    }

    println(len)
}