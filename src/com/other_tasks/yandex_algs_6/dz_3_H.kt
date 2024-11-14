package com.other_tasks.yandex_algs_6


import java.math.BigInteger
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val mainStack = Stack<BigInteger>()
    val sumStack = Stack<BigInteger>()

    for (i in 0 until n) {
        val s = readln().trim()
        when (s.first()) {
            '-' -> {
                println(mainStack.pop())
                sumStack.pop()
            }

            '+' -> {
                val x = s.drop(1).toBigInteger()
                mainStack.push(x)
                val newSum = (sumStack.lastOrNull() ?: BigInteger.ZERO) + x
                sumStack.push(newSum)
            }

            '?' -> {
                val k = s.drop(1).toInt()
                val temp = if (sumStack.size > k) {
                    sumStack[sumStack.size - k - 1]
                } else {
                    BigInteger.ZERO
                }
                val sum = sumStack.last() - temp
                println(sum)
            }
        }
    }
}


//
//fun main(){
//
//    val n = readln().toInt()
//    val mainStack = Stack<Int>()
//    val tempStack = Stack<Int>()
//
//
//    for (i in 0..<n){
//        val s = readln().trim()
//        when(s.first()){
//            '-' -> {
//                println(mainStack.pop())
//            }
//            '+' -> {
//                val a = s.drop(1).toInt()
//                mainStack.push(a)
//            }
//            '?' -> {
//                var sum = 0
//                val k = s.drop(1).toInt()
//                for (j in 0..<k){
//                    val t = mainStack.pop()
//                    sum+= t
//                    tempStack.push(t)
//                }
//                println(sum)
//                for (j in 0..<k){
//                    val t = tempStack.pop()
//                    mainStack.push(t)
//                }
//            }
//        }
//    }
//}