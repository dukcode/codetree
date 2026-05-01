package org.dukcode.ps.codetree.trail02.chapter05.lesson02.challengeKeepTheLead

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val MX = 1_000_000

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-keep-the-lead/description">LINK</a>
 */
fun main() {
    val (n, m) = parseInts()

    val a = buildPositions(n)
    val b = buildPositions(m)

    bw.write(cntLeadChange(a, b).toString())

    bw.flush()
}

fun cntLeadChange(
    a: IntArray,
    b: IntArray,
): Int {
    var cnt = 0

    var lead = 0
    for (second in 0..MX) {
        if (a[second] == Int.MAX_VALUE || b[second] == Int.MAX_VALUE) {
            return cnt
        }

        val newLead =
            if (a[second] > b[second]) {
                1
            } else if (a[second] < b[second]) {
                -1
            } else {
                lead
            }

        if (lead != 0 && newLead != lead) {
            cnt++
        }

        lead = newLead
    }

    return cnt
}

private fun buildPositions(n: Int): IntArray {
    val positions = IntArray(MX + 1) { Integer.MAX_VALUE }

    positions[0] = 0

    var second = 1
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val v = st.nextToken().toInt()
        val t = st.nextToken().toInt()

        repeat(t) {
            positions[second] = positions[second - 1] + v
            second++
        }
    }

    return positions
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
