package com.other_tasks.yandex_algs_6

import java.util.*

fun main() {
    val (n, k) = readln().trim().split(" ").map { it.toInt() }
    val arr = readln().trim().split(" ").map { it.toInt() }
    val sortArr = arr.sorted()
    var res = 0

    if (k == 0) {
        val maxFrequency = sortArr
            .groupingBy { it }
            .eachCount()
            .values.maxOrNull()
        if (maxFrequency != null) {
            res = maxFrequency
        }
    } else {
        val ans = PriorityQueue<Int>()

        for (num in sortArr) {
            if (ans.isNotEmpty() && num - ans.peek() > k) {
                ans.poll()
            }
            ans.add(num)
        }
        res = ans.size
    }

    println(res)
}
