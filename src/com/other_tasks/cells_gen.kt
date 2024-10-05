package com.other_tasks
fun removeLastOccurrence(list: MutableList<Int>, number: Int) {
    // Find the index of the last occurrence of the number
    val lastIndex = list.lastIndexOf(number)

    // If the number exists in the list, remove it
    if (lastIndex != -1) {
        list.removeAt(lastIndex)
    }
}
fun main() {
    val numbers = mutableListOf(1, 0, 0, 1, 1, 1, 2, 0, 1, 1, 0, 1, 1, 1, 2, 0, 0, 1, 0, 1, 0, 0, 0)
    println("Original list: $numbers")

    removeLastOccurrence(numbers, 2)
    println("After removing last occurrence of 2: $numbers")
}
