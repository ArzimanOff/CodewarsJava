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
    val descendants = mutableMapOf<String, Int>()

    fun count(node: String): Int {
        val childCount = tree[node]?.sumOf { count(it) } ?: 0
        descendants[node] = childCount
        return childCount + 1
    }

    count(root)

    descendants.keys.sorted().forEach { name ->
        println("$name ${descendants[name]}")
    }
}
