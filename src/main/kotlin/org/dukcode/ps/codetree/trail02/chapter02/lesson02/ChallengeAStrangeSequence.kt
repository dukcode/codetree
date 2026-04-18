package org.dukcode.ps.codetree.trail02.chapter02.lesson02.challengeAStrangeSequence

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-a-strange-sequence/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    bw.write(seq(n).toString())

    bw.flush()
}

private fun seq(n: Int): Int {
    if (n <= 2) {
        return n
    }

    return seq(n / 3) + seq(n - 1)
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
