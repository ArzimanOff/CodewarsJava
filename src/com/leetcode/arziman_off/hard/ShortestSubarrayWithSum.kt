package com.leetcode.arziman_off.hard

class ShortestSubarrayWithSum {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        var ans = 100000
        var flag = false
        val prefSum = MutableList<Int>(nums.size+1){0}
        for (i in nums.indices){
            prefSum[i+1] = nums[i] + prefSum[i]
        }
        println(prefSum)
        var dq = ArrayDeque<Int>()
        for (i in prefSum){
            println(dq)
            dq.addLast(i)
            while (dq.last() - dq.first() >= k){
                println("=s=")
                ans = minOf(ans, dq.size-1)
                flag = true
                dq.removeFirst()
                println(dq)
                println("=e=")
            }
        }
        if (!flag) ans = -1
        return ans
    }
}

fun main(){
    val arr = readln().trim().split(" ").map { it.toInt() }.toIntArray()
    val k = readln().toInt()
    val s = ShortestSubarrayWithSum()
    println(s.shortestSubarray(arr, k))
}

// 84 -37 32 40 95