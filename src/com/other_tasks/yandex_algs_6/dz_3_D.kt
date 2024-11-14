package com.other_tasks.yandex_algs_6

import jdk.dynalink.Operation
import java.util.Stack

fun main() {
    val s = readln().trim().split(" ")
    val stack = Stack<Int>()
    val operations = listOf("+", "-", "*")
    for (ch in s){
        if (ch in operations){
            val a = stack.pop()
            val b = stack.pop()
            val ans = operate(a, b, ch)
            stack.push(ans)
        } else {
            stack.push(ch.toInt())
        }
    }
    println(stack.peek())
}

fun operate(a: Int, b:Int, operation: String): Int{
    return when (operation){
        "-" -> b - a
        "+" -> a + b
        "*" -> a * b
        else -> {
            0
        }
    }
}