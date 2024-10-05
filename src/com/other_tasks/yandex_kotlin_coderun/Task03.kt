package com.other_tasks.yandex_kotlin_coderun

import java.math.BigInteger
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (w, h) = reader.readLine()!!.trim().split(" ").map { it.toInt() }
    val tempW = if (w % 2 == 0) {
        w / 2
    } else {
        (w + 1) / 2
    }
    val tempH = if (h % 2 == 0) {
        h / 2
    } else {
        (h + 1) / 2
    }

    val listW = mutableListOf<BigInteger>()
    val listH = mutableListOf<BigInteger>()
    val two = BigInteger.valueOf(2)
    for (i in 0 until tempH) {
        var sum = BigInteger.ZERO
        for (j in 0 until tempW) {
            val n = (i + 1).toBigInteger() * (j + 1).toBigInteger() * (w - j).toBigInteger() * (h - i).toBigInteger()
            sum += if (j == tempW - 1) {
                if (w % 2 == 0) {
                    n * two
                } else {
                    n
                }
            } else {
                n * two
            }
        }
        listH.add(sum)
    }
    for (j in 0 until tempW) {
        var sum = BigInteger.ZERO
        for (i in 0 until tempH) {
            val n = (i + 1).toBigInteger() * (j + 1).toBigInteger() * (w - j).toBigInteger() * (h - i).toBigInteger()
            sum += if (i == tempH - 1) {
                if (h % 2 == 0) {
                    n * two
                } else {
                    n
                }
            } else {
                n * two
            }
        }
        listW.add(sum)
    }


    writer.write(
        listH
            .joinToString(" ")
    )

    writer.write(" ")
    if (h % 2 == 0) {
        writer.write(
            listH
                .reversed()
                .joinToString(" ")
        )
        writer.newLine()
    } else {
        writer.write(
            listH
                .reversed()
                .drop(1)
                .joinToString(" ")
        )
        writer.newLine()
    }

    writer.write(
        listW
            .joinToString(" ")
    )
    writer.write(" ")
    if (w % 2 == 0) {
        writer.write(
            listW
                .reversed()
                .joinToString(" ")
        )
    } else {
        writer.write(
            listW
                .reversed()
                .drop(1)
                .joinToString(" ")
        )
    }

    reader.close()
    writer.close()
}

