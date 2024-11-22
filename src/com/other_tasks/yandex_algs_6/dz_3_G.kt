package com.other_tasks.yandex_algs_6

import java.math.BigInteger
import kotlin.math.min

fun main(){
    val (n, b) = readln().trim().split(" ").map {
        it.toInt()
    }
    val arr = readln().split(" ").map {
        it.toInt()
    }

    var ans = BigInteger.ZERO
    var queueLen = BigInteger.ZERO
    for (i in arr){
        queueLen += i.toBigInteger()
        ans += queueLen
        queueLen -= if (queueLen < b.toBigInteger()){
            queueLen
        } else {
            b.toBigInteger()
        }
    }
    ans += queueLen
    println(ans)
}