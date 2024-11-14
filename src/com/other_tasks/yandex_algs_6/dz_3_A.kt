package com.other_tasks.yandex_algs_6

import java.util.Stack


fun main() {
    val s = readln().trim()
    val ans = if (checkSequence(s)){
        "yes"
    } else {
        "no"
    }
    println(ans)
}

fun checkSequence(s: String): Boolean {
    var res = true
    val sArr =  s.toCharArray()
    val stack = Stack<Char>()
    val opens = listOf('(', '[', '{')
    val closes = listOf(')', ']', '}')

    for (ch in sArr){
        if (ch in opens){
            stack.push(ch)
        } else if (ch in closes){
            if (!stack.empty() &&
                opens.indexOf(stack.peek()) == closes.indexOf(ch)){
                stack.pop()
            } else {
                res = false
                break
            }
        }
    }

    if (!stack.empty()){
        res = false
    }

    return res
}