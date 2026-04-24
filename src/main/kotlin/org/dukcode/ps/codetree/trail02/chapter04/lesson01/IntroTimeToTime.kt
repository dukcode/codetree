package org.dukcode.ps.codetree.trail02.chapter04.lesson01.introTimeToTime

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-time-to-time/description">LINK</a>
 */
fun main() {
    val (h1, m1, h2, m2) = parseInts()

    val elapsedMin = toMinutes(h2, m2) - toMinutes(h1, m1)

    bw.write(elapsedMin.toString())

    bw.flush()
}

private fun toMinutes(
    h: Int,
    m: Int,
): Int = 60 * h + m

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
