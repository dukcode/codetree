package org.dukcode.ps.codetree.trail02.chapter04.lesson01.challengeGuessDayOfWeek

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val daysInMonth = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
private val dayOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-guess-day-of-week/description">LINK</a>
 */
fun main() {
    val (m1, d1, m2, d2) = parseInts()

    val offset = toDays(m2, d2) - toDays(m1, d1)

    bw.write(dayOfWeek[((offset % 7) + 7) % 7])

    bw.flush()
}

private fun toDays(
    m: Int,
    d: Int,
): Int = daysInMonth.take(m - 1).sum() + d

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
