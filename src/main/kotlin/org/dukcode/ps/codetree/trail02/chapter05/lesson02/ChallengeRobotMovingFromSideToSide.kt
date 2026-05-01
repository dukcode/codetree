package org.dukcode.ps.codetree.trail02.chapter05.lesson02.challengeRobotMovingFromSideToSide

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val MX = 2_000_000

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-robot-moving-from-side-to-side/description">LINK</a>
 */
fun main() {
    val (n, m) = parseInts()

    val a = buildPositions(n)
    val b = buildPositions(m)

    bw.write(count(a, b).toString())

    bw.flush()
}

fun count(
    a: IntArray,
    b: IntArray,
): Int {
    var cnt = 0
    for (time in 1..MX) {
        if (a[time] == Int.MAX_VALUE && b[time] == Int.MAX_VALUE) {
            return cnt
        }

        if (a[time] == Int.MAX_VALUE) {
            a[time] = a[time - 1]
        }

        if (b[time] == Int.MAX_VALUE) {
            b[time] = b[time - 1]
        }

        if (a[time - 1] != b[time - 1] && a[time] == b[time]) {
            cnt++
        }
    }

    return cnt
}

private fun buildPositions(n: Int): IntArray {
    val positions = IntArray(MX + 1) { Integer.MAX_VALUE }
    positions[0] = 0

    var time = 1
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val t = st.nextToken().toInt()
        val d = if (st.nextToken() == "L") -1 else 1

        repeat(t) {
            positions[time] = positions[time - 1] + d
            time++
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
