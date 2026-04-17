package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val daysInMonth = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

fun main() {
    val (year, month, day) = parseInts()

    bw.write(calcSeason(year, month, day))
    bw.newLine()

    bw.flush()
}

private fun calcSeason(
    year: Int,
    month: Int,
    day: Int,
): String =
    when {
        !exists(year, month, day) -> "-1"
        month in 3..5 -> "Spring"
        month in 6..8 -> "Summer"
        month in 9..11 -> "Fall"
        else -> "Winter"
    }

private fun exists(
    year: Int,
    month: Int,
    day: Int,
): Boolean {
    val days = if (isLeapYear(year) && month == 2) 29 else daysInMonth[month - 1]
    return day <= days
}

private fun isLeapYear(year: Int): Boolean {
    if (year % 4 == 0) {
        if (year % 100 == 0) {
            return year % 400 == 0
        }

        return true
    }

    return false
}

private fun parseInts(): IntArray {
    val st = StringTokenizer(br.readLine())
    return IntArray(st.countTokens()) { st.nextToken().toInt() }
}
