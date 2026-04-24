package org.dukcode.ps.codetree.trail02.chapter04.lesson01.challengeDatetimeToDatetime

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-datetime-to-datetime/description">LINK</a>
 */
fun main() {
    val (d, h, m) = parseInts()

    val elapsed = toMinutes(d, h, m) - toMinutes(11, 11, 11)

    bw.write((if (elapsed < 0) -1 else elapsed).toString())

    bw.flush()
}

private fun toMinutes(
    d: Int,
    h: Int,
    m: Int,
): Int = ((d - 1) * 24 + h) * 60 + m

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
