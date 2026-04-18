package org.dukcode.ps.codetree.trail02.chapter02.lesson02.challengeOutputValueBasedOnOddEvenNumbers

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-output-value-based-on-odd-even-numbers/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    bw.write(calc(n).toString())

    bw.flush()
}

private fun calc(n: Int): Int {
    if (n <= 2) {
        return n
    }

    return n + calc(n - 2)
}
