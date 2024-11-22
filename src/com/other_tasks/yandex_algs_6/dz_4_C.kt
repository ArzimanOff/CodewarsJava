package com.other_tasks.yandex_algs_6

fun main() {
    val v = readln().toInt()
    val graph = Array(v + 1) { mutableListOf<Int>() }

    for (i in 0 until v - 1){
        val (u, w) = readln().split(" ").map { it.toInt() }
        graph[u].add(w)
        graph[w].add(u)
    }

    val subtreeSizes = IntArray(v + 1)
    val visited = BooleanArray(v + 1)

    fun find(node: Int): Int {
        visited[node] = true
        var size = 1
        for (neighbor in graph[node]) {
            if (!visited[neighbor]) {
                size += find(neighbor)
            }
        }
        subtreeSizes[node] = size
        return size
    }

    find(1)

    println(subtreeSizes.drop(1).joinToString(" "))
}
