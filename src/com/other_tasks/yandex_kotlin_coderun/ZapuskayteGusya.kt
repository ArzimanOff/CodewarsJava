package com.other_tasks.yandex_kotlin_coderun


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

const val WORD = "goose"
fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n, k) = reader.readLine().split(" ").map { it.toInt() }
    val sitesMap = mutableSetOf<String>()
    for (i in 0 until n){
        val siteName = reader.readLine()
        val title = reader.readLine()

        if (getWordsCount(title) >= k){
            sitesMap.add(siteName)
        }
    }

    println(sitesMap.size)
    sitesMap.sorted().forEach{
        writer.write(it)
        writer.newLine()
    }

    reader.close()
    writer.close()
}

fun getWordsCount(title: String?): Int {
    var cnt = title?.split(" ", "/", ".", ",", "\"", "'", ")", "(", "\\", "?", "!")?.count{
        it == WORD
    } ?: 0

    return cnt
}
