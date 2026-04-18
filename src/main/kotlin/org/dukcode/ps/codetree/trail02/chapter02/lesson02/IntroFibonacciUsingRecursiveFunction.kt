package org.dukcode.ps.codetree.trail02.chapter02.lesson02.introFibonacciUsingRecursiveFunction

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-fibonacci-using-recursive-function/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    bw.write(fibonacci(n).toString())

    bw.flush()
}

fun fibonacci(n: Int): Int {
    if (n <= 2) {
        return 1
    }

    return fibonacci(n - 1) + fibonacci(n - 2)
}
