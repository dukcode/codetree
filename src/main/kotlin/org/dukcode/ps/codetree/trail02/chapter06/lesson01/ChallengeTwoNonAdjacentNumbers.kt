package org.dukcode.ps.codetree.trail02.chapter06.lesson01.challengeTwoNonAdjacentNumbers

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-two-non-adjacent-numbers/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val arr = parseInts()

    val maxPairSum = (0 until n - 2).maxOf { i -> (i + 2 until n).maxOf { j -> arr[i] + arr[j] } }

    bw.write(maxPairSum.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
