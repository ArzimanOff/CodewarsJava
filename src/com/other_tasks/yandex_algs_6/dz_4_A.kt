package com.other_tasks.yandex_algs_6


fun main() {
    val n = readln().toInt()
    val tree = mutableMapOf<String, MutableList<String>>()
    val allNodes = mutableSetOf<String>()
    val children = mutableSetOf<String>()

    for (i in 0 until n - 1){
        val (child, parent) = readln().split(" ")
        tree.computeIfAbsent(parent) { mutableListOf() }.add(child)
        allNodes.add(parent)
        allNodes.add(child)
        children.add(child)
    }

    val root = (allNodes - children).first()
    val heights = mutableMapOf<String, Int>()

    fun calculateHeight(node: String, height: Int) {
        heights[node] = height
        for (child in tree[node].orEmpty()) {
            calculateHeight(child, height + 1)
        }
    }

    calculateHeight(root, 0)

    heights.keys.sorted().forEach { name ->
        println("$name ${heights[name]}")
    }
}
