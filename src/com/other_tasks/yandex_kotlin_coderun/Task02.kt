package com.other_tasks.yandex_kotlin_coderun
import java.util.*


private fun ask(date: String) {
    System.out.printf("? %s\n", date)
    System.out.flush()
}

private fun print(answer: String) {
    System.out.printf("! %s\n", answer)
    System.out.flush()
}


fun main(args: Array<String>) {
    // read game configuration
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    // write your code here
}
