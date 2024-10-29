package com.other_tasks.yandex_algs_6


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))


    val x1 = reader.readLine().toInt()
    val y1 = reader.readLine().toInt()

    val x2 = reader.readLine().toInt()
    val y2 = reader.readLine().toInt()

    val x = reader.readLine().toInt()
    val y = reader.readLine().toInt()
    val ans: String = run(x1, y1, x2, y2, x, y)
    writer.write(ans)
    reader.close()
    writer.close()
}

private fun run(x1: Int, y1: Int, x2: Int, y2: Int, x: Int, y: Int): String {

    val a: String = when {
        (y >= y2) -> "N"
        (y <= y1) -> "S"
        else -> ""
    }

    val b: String = when {
        (x <= x1) -> "W"
        (x >= x2) -> "E"
        else -> ""
    }

    return a + b
}