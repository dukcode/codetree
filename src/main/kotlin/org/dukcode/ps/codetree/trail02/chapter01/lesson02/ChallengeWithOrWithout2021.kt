package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val days = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-with-or-without-2021/description">LINK</a>
 */
fun main() {
    val (month, day) = parseInts()

    bw.write(if (hasDay(month, day)) "Yes" else "No")

    bw.flush()
}

private fun hasDay(
    month: Int,
    day: Int,
): Boolean = month <= 12 && days[month - 1] >= day

private fun parseInts(): IntArray {
    val st = StringTokenizer(br.readLine())
    return IntArray(st.countTokens()) { st.nextToken().toInt() }
}
