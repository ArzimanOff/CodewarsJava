package com.other_tasks.yandex_algs_6


fun main() {
    val (n, k) = readln().split(" ").map {
        it.toInt()
    }
    val arr = readln().trim().split(" ").map {
        it.toInt()
    }
    val ansArrLen = n - (k - 1)
    val ansArr = MutableList(ansArrLen) { 0 }
    val deque = ArrayDeque<Int>()

    for (i in 0..<n) {
        if (!deque.isEmpty() && deque.first() <= i - k) {
            deque.removeFirst()
        }
        while (!deque.isEmpty() && arr[deque.last()] > arr[i]) {
            deque.removeLast()
        }
        deque.addLast(i)
        if (i >= k - 1) {
            ansArr[i - k + 1] = arr[deque.first()]
        }
    }

    ansArr.forEach {
        println(it)
    }
}