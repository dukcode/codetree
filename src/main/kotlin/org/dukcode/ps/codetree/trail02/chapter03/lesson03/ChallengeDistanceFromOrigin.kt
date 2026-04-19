package org.dukcode.ps.codetree.trail02.chapter03.lesson03.challengeDistanceFromOrigin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.abs

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-distance-from-origin/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val points =
        List(n) {
            val (x, y) = parseInts()
            Point(it + 1, x, y)
        }.sortedWith(compareBy(Point::distance, Point::number))

    points.forEach {
        bw.write(it.number.toString())
        bw.newLine()
    }

    bw.flush()
}

private class Point(
    val number: Int,
    val x: Int,
    val y: Int,
) {
    val distance: Int
        get() = abs(x) + abs(y)
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
