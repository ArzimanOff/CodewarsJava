package com.other_tasks.yandex_algs_6

import java.util.Stack

fun main(){
    val n = readln().toInt()
    val arr = readln().trim().split(" ").map {
        it.toInt()
    }
    val ansArr = MutableList(n){0}
    val stack = Stack<Pair<Int, Int>>()

    for (i in 0..<n){
        if (!stack.empty()){
            var peekVal = stack.peek()
            while (peekVal != null && peekVal.first > arr[i]){
                ansArr[peekVal.second] = i
                stack.pop()
                peekVal = if (!stack.empty()){
                    stack.peek()
                } else {
                    null
                }
            }
            stack.push(Pair(arr[i], i))
        } else {
            stack.push(Pair(arr[i], i))
        }
    }
    while (!stack.empty()){
        val index = stack.peek().second
        ansArr[index] = -1
        stack.pop()
    }
    println(ansArr.joinToString(separator = " "))
}

