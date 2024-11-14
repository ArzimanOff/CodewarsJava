package com.other_tasks.yandex_algs_6
fun main() {
    val n = readln().toInt()
    val arr = readln().trim().split(" ").map { it.toInt() }

    val leftCost = LongArray(n)
    val rightCost = LongArray(n)

    var leftSum = 0L
    for (i in 1 until n) {
        leftSum += arr[i - 1]
        leftCost[i] = leftCost[i - 1] + leftSum
    }

    var rightSum = 0L
    for (i in n - 2 downTo 0) {
        rightSum += arr[i + 1]
        rightCost[i] = rightCost[i + 1] + rightSum
    }

    var minSteps = Long.MAX_VALUE
    for (i in 0 until n) {
        minSteps = minOf(minSteps, leftCost[i] + rightCost[i])
    }



    println(minSteps)
}
