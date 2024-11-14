package com.other_tasks.yandex_algs_6

import java.util.Deque
import java.util.LinkedList
import java.util.Queue

fun main(){
    val (n, b) = readln().trim().split(" ").map {
        it.toInt()
    }
    val arr = readln().split(" ").map {
        it.toInt()
    }.toMutableList()
    val deque: Deque<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    var ans = 0
    var c = 0

    for (i in 0..<n){
        println(deque)
        deque.addLast(Pair(arr[i], i))
        val f = deque.peekFirst()
        if (f.first <= b){
            ans += f.first * (i - f.second + 1)
            deque.removeFirst()
        } else {
            ans += b * (i - f.second + 1)
            deque.removeFirst()
            deque.addFirst(Pair(f.first-b, i))
        }
        println(deque)
    }

}