package com.other_tasks.yandex_kotlin_coderun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter



fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))


    var num = reader.readLine().toInt()
    var numArr = num.toString().map { it.toString().toInt() }
    while (
        findFirsSum(numArr) != findLastSum(numArr)
    ){
        num++
        numArr = num.toString().map { it.toString().toInt() }
    }
    println(num)

    reader.close()
    writer.close()
}

fun findFirsSum(numArr: List<Int>): Int {
    return numArr.take(3).sum()
}

fun findLastSum(numArr: List<Int>): Int {
    return numArr.takeLast(3).sum()
}
