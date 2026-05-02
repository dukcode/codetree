package org.dukcode.ps.codetree.trail02.chapter05.lesson03.introMoveInDirection

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

// N, S, E, W
private val dx = listOf(0, 0, 1, -1)
private val dy = listOf(1, -1, 0, 0)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-move-in-direction/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val point = Point(0, 0)
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val dir =
            when (st.nextToken()) {
                "N" -> 0
                "S" -> 1
                "E" -> 2
                "W" -> 3
                else -> throw IllegalStateException()
            }
        val dist = st.nextToken().toInt()

        point.x += dx[dir] * dist
        point.y += dy[dir] * dist
    }

    bw.write("${point.x} ${point.y}")

    bw.flush()
}

private data class Point(
    var x: Int,
    var y: Int,
)
