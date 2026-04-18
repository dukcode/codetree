package org.dukcode.ps.codetree.trail02.chapter03.lesson01.challengeKthNumber

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-kth-number/description">LINK</a>
 */
fun main() {
    val (_, k) = parseInts()
    val arr = parseInts()

    bw.write(arr.top(k).toString())

    bw.flush()
}

private fun IntArray.top(order: Int) = this.sorted()[order - 1]

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
