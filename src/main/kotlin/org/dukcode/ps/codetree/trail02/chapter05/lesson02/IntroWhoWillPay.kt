package org.dukcode.ps.codetree.trail02.chapter05.lesson02.introWhoWillPay

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-who-will-pay/description">LINK</a>
 */
fun main() {
    val (n, m, k) = parseInts()

    val penalties = IntArray(n + 1)

    bw.write(solve(m, penalties, k).toString())

    bw.flush()
}

private fun solve(
    m: Int,
    penalties: IntArray,
    k: Int,
): Int {
    repeat(m) {
        val student = br.readLine().toInt()
        penalties[student] += 1

        if (penalties[student] >= k) {
            return student
        }
    }
    return -1
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
