package com.other_tasks.yandex_algs_6

fun main() {
    val (n, k) = readln().trim().split(" ").map { it.toInt() }
    val arr = readln().trim().split(" ").map {
        it.toInt()
    }
    var cnt = 0
    var sum = 0
    val prefixCount = mutableMapOf(0 to 1)
    for (i in arr) {
        sum += i
        cnt += prefixCount.getOrDefault(sum - k, 0)
        prefixCount[sum] = prefixCount.getOrDefault(sum, 0) + 1
    }
    println(cnt)
}
