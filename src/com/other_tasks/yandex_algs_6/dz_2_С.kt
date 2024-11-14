package com.other_tasks.yandex_algs_6


fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toLong() }
    val arr = readln().trim().split(" ").map {
        it.toLong()
    }
    var cnt = 0L

    var l = 0
    var r = 1
    while (l < n - 1 && r.toLong() != n) {
        if (arr[r.toInt()] - arr[l.toInt()] > m) {
            cnt += n - r
            l++
        } else {
            r++
        }
    }
    println(cnt)
}

