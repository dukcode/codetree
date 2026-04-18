package org.dukcode.ps.codetree.trail02.chapter03.lesson01.challengeTwoEqualSeries

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-two-equal-series/description">LINK</a>
 */
fun main() {
    skipLine()
    bw.write(if (parseInts().sorted() == parseInts().sorted()) "Yes" else "No")
    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }

private fun skipLine() = br.readLine()
