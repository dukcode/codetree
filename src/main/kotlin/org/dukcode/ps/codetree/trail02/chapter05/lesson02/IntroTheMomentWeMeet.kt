package org.dukcode.ps.codetree.trail02.chapter05.lesson02.introTheMomentWeMeet

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val MX = 1_000_000

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-the-moment-we-meet/description">LINK</a>
 */
fun main() {
    val (n, m) = parseInts()

    val a = buildPositions(n)
    val b = buildPositions(m)

    bw.write(findFirstMeetingSeconds(a, b).toString())

    bw.flush()
}

private fun buildPositions(n: Int): IntArray {
    var second = 1
    val positions = IntArray(MX + 1) { Int.MAX_VALUE }

    positions[0] = 0
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val d = if (st.nextToken() == "L") -1 else 1
        var t = st.nextToken().toInt()

        while (t-- > 0) {
            positions[second] = positions[second - 1] + d
            second++
        }
    }

    return positions
}

private fun findFirstMeetingSeconds(
    a: IntArray,
    b: IntArray,
): Int {
    for (second in 1..MX) {
        if (a[second] == Int.MAX_VALUE || b[second] == Int.MAX_VALUE) {
            return -1
        }

        if (a[second] == b[second]) {
            return second
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
