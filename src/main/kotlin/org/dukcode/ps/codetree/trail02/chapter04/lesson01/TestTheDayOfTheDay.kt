package org.dukcode.ps.codetree.trail02.chapter04.lesson01.testTheDayOfTheDay

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val daysInMonth = intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-the-day-of-the-day/description">LINK</a>
 */
fun main() {
    val (m1, d1, m2, d2) = parseInts()
    val targetWeekDay =
        when (br.readLine()) {
            "Mon" -> 0
            "Tue" -> 1
            "Wed" -> 2
            "Thu" -> 3
            "Fri" -> 4
            "Sat" -> 5
            "Sun" -> 6
            else -> throw IllegalStateException()
        }

    val dayOffset = toDays(m2, d2) - toDays(m1, d1)
    val countWeekDay = dayOffset / 7 + if (dayOffset % 7 >= targetWeekDay) 1 else 0

    bw.write(countWeekDay.toString())

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
