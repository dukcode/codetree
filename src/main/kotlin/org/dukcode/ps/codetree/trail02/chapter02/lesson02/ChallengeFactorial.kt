package org.dukcode.ps.codetree.trail02.chapter02.lesson02.challengeFactorial

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-factorial/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    bw.write(factorial(n).toString())

    bw.flush()
}

fun factorial(n: Int): Int {
    if (n == 1) {
        return 1
    }

    return n * factorial(n - 1)
}
