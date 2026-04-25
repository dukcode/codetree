package org.dukcode.ps.codetree.trail02.chapter04.lesson03.challengeMaximumOverlappedPoints

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val MX = 100

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-overlapped-points/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val lines = IntArray(MX + 1)
    var maxOverlap = 0
    repeat(n) {
        val (frIn, toIn) = parseInts()
        for (idx in frIn..toIn) {
            lines[idx]++
            maxOverlap = maxOf(maxOverlap, lines[idx])
        }
    }

    bw.write(maxOverlap.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
