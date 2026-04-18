package org.dukcode.ps.codetree.trail02.chapter02.lesson02.challengeSequenceOfRemainderDividedBy100

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sequence-of-remainder-divided-by-100/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    bw.write(seq(n).toString())

    bw.flush()
}

private fun seq(n: Int): Int {
    if (n <= 2) {
        return n * 2
    }

    return seq(n - 1) * seq(n - 2) % 100
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
