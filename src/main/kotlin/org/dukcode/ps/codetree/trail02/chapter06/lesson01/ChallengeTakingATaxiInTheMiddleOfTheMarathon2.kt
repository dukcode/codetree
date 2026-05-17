package org.dukcode.ps.codetree.trail02.chapter06.lesson01.challengeTakingATaxiInTheMiddleOfTheMarathon2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.abs

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-taking-a-taxi-in-the-middle-of-the-marathon-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val points =
        Array(n) {
            val (x, y) = parseInts()
            Point(x, y)
        }

    val ans =
        (1 until n - 1).minOf { skip ->
            points.indices
                .filter { idx -> idx != skip }
                .zipWithNext()
                .sumOf { (from, to) -> points[from].distanceTo(points[to]) }
        }

    bw.write(ans.toString())

    bw.flush()
}

private class Point(
    val x: Int,
    val y: Int,
) {
    fun distanceTo(other: Point): Int = abs(x - other.x) + abs(y - other.y)
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
