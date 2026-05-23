package org.dukcode.ps.codetree.trail02.chapter06.lesson02.introMaxSumOfSubarray

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-max-sum-of-subarray/description">LINK</a>
 */
fun main() {
    val (n, k) = parseInts()
    val arr = parseInts()

    var maxSum = 0
    for (frIn in 0 until n - k + 1) {
        val toEx = frIn + k - 1
        maxSum = maxOf(maxSum, (frIn..toEx).sumOf { arr[it] })
    }

    bw.write(maxSum.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
