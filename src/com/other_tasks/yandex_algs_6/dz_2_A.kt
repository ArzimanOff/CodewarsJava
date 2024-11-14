package com.other_tasks.yandex_algs_6

fun main() {
    val n = readln().toInt()
    val arr = readln().trim().split(" ").map {
        it.toInt()
    }
    val prefArr = prefixArr(arr, false)
    val ans = prefArr.joinToString(separator = " ")
    println(ans)
}

fun prefixArr(arr: List<Int>, flag: Boolean): List<Int> {
    val prefArr = mutableListOf(0)
    for (i in arr.indices){
        prefArr.add(arr[i] + prefArr[i])
    }
    return if (flag){
        prefArr
    }else{
        prefArr.drop(1)
    }
}