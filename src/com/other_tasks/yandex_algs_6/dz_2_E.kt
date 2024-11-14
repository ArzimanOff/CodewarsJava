package com.other_tasks.yandex_algs_6


fun main() {
    val n = readln().toInt()
    val arr = readln().trim().split(" ").map { it.toInt() }

    val sortArr = arr.sorted().toMutableList()
    var l = 0
    var r = 0
    val ansArr = mutableListOf<Int>()

    while (sortArr.isNotEmpty()){
        val LR = getLR(sortArr)
        l = LR.first
        r = LR.second
        if (l == r){
            ansArr.add(sortArr[l])
            sortArr.removeAt(l)
        }else{
            if (sortArr[l] <= sortArr[r]){
                ansArr.add(sortArr[l])
                sortArr.removeAt(l)
            } else {
                ansArr.add(sortArr[r])
                sortArr.removeAt(r)
            }
        }
    }
    println(ansArr.joinToString(separator = " "))
}

fun getLR(sortArr: MutableList<Int>): Pair<Int, Int>{
    val n = sortArr.size
    var l = 0
    var r = 0
    if (n%2==0){
        l = n/2-1
        r = n/2
    } else {
        l = n/2
        r = l
    }
    return Pair(l, r)
}
