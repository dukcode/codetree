package org.dukcode.ps.codetree.trail02.chapter02.lesson02.challengeSumOfLargeNumericDigits

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-large-numeric-digits/description">LINK</a>
 */
fun main() {
    val (a, b, c) = parseInts()

    bw.write((a * b * c).digitSum().toString())

    bw.flush()
}

private fun Int.digitSum(): Int {
    if (this == 0) {
        return 0
    }

    return this % 10 + (this / 10).digitSum()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
