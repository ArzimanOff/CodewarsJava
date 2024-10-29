package com.other_tasks.yandex_algs_6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))


    val a = reader.readLine().toInt()
    val b = reader.readLine().toInt()

    val c = reader.readLine().toInt()
    val d = reader.readLine().toInt()

    val ans: Pair<Int, Int> = run(a, b, c, d)
    writer.write("${ans.first} ${ans.second}")
    writer.newLine()

    reader.close()
    writer.close()

}

fun run(a: Int, b: Int, c: Int, d: Int): Pair<Int, Int> {

    var x = 0
    var y = 0

    val pairsList = mutableMapOf<Int, Pair<Int, Int>>()
    if (!listOf(a, b, c, d).contains(0)) {
        val maxOverall = maxOf(a, b, c, d)
        if (maxOverall == a || maxOverall == b) {
            x = 1
            y = max(c, d) + 1
        } else {
            x = max(a, b) + 1
            y = 1
        }
        pairsList[x + y] = Pair(x, y)

        if (
            !(min(a, b) == a && min(c, d) == d) &&
            !(min(a, b) == b && min(c, d) == c)
        ) {
            x = min(a, b) + 1
            y = min(c, d) + 1
            pairsList[x + y] = Pair(x, y)
        }

        val sortedList = pairsList.toList().sortedBy { it.first }
        val sortedMap = sortedList.toMap()
        return sortedMap.values.first()
    } else {
        x = min(a, b) + 1
        y = min(c, d) + 1
        if (a == 0) {
            y = c + 1
        } else if (b == 0) {
            y = d + 1
        } else if (c == 0) {
            x = a + 1
        } else if (d == 0) {
            x = b + 1
        }
        return Pair(x, y)
    }
}