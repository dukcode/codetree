package org.dukcode.ps.codetree.trail02.chapter05.lesson02.testKeepTheLead3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val MX = 1_000_000

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-keep-the-lead-3/description">LINK</a>
 */
fun main() {
    val (n, m) = parseInts()

    val (aPositions, aTime) = buildPositions(n)
    val (bPositions, bTime) = buildPositions(m)

    var cnt = 0
    for (time in 1 until minOf(aTime, bTime)) {
        if (compareValues(aPositions[time - 1], bPositions[time - 1])
            != compareValues(aPositions[time], bPositions[time])
        ) {
            cnt++
        }
    }

    bw.write(cnt.toString())

    bw.flush()
}

private fun buildPositions(n: Int): Pair<IntArray, Int> {
    val positions = IntArray(MX + 1) { Int.MAX_VALUE }
    positions[0] = 0

    var time = 1
    repeat(n) {
        val (v, t) = parseInts()

        repeat(t) {
            positions[time] = positions[time - 1] + v
            time++
        }
    }

    return positions to time
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
