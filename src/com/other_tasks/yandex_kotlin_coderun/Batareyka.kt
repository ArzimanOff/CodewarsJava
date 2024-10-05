package com.other_tasks.yandex_kotlin_coderun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val list = reader.readLine().split(" ").map { it.toInt() }
    println(100 / list.sum())


    reader.close()
    writer.close()
}