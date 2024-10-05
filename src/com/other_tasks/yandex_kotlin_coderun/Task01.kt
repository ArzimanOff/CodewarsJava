package com.other_tasks.yandex_kotlin_coderun

import java.util.*
fun main() {
    val data = TreeMap<Int, String>()
    while (true) {
        val s = readLine()?.trim() ?: break
        val (index, value) = parseInput(s)
        data[index] = value
    }

    for (value in data.values) {
        println(value)
    }
}

private fun parseInput(s: String): Pair<Int, String> {
    val index = StringBuilder()
    val value = StringBuilder()

    for (char in s) {
        if (char.isDigit()) {
            index.append(char)
        } else {
            value.append(char)
        }
    }

    return index.toString().toInt() to value.toString()
}
