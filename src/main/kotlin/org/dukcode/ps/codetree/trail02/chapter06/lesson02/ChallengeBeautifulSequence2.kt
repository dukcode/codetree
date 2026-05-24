package org.dukcode.ps.codetree.trail02.chapter06.lesson02.challengeBeautifulSequence2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-beautiful-sequence-2/description">LINK</a>
 */
fun main() {
    val (n, m) = parseInts()
    val a = parseInts()
    val b = parseInts().sortedArray()

    var cnt = 0
    for (frIn in 0 until n - m + 1) {
        val toEx = frIn + m
        if (a.copyOfRange(frIn, toEx).sortedArray().contentEquals(b)) {
            cnt++
        }
    }

    bw.write(cnt.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
