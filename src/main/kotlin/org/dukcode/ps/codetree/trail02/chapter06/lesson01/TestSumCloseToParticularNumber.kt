package org.dukcode.ps.codetree.trail02.chapter06.lesson01.testSumCloseToParticularNumber

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.abs

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-sum-close-to-particular-number/description">LINK</a>
 */
fun main() {
    val (n, s) = parseInts()
    val arr = parseInts()

    val sumTotal = arr.sum()
    val ans =
        (0 until n - 1).minOf { i ->
            (i + 1 until n).minOf { j ->
                val sum = sumTotal - arr[i] - arr[j]
                abs(sum - s)
            }
        }

    bw.write(ans.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
