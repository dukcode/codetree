package org.dukcode.ps.codetree.trail02.chapter05.lesson03.introSmallMarbleMovement

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

// D, U, R, L
private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-small-marble-movement/description">LINK</a>
 */
fun main() {
    val (n, t) = parseInts()

    val st = StringTokenizer(br.readLine())
    var y = st.nextToken().toInt()
    var x = st.nextToken().toInt()
    var dir =
        when (st.nextToken()) {
            "D" -> 0
            "U" -> 1
            "R" -> 2
            "L" -> 3
            else -> throw IllegalStateException()
        }

    repeat(t) {
        val ny = y + dy[dir]
        val nx = x + dx[dir]

        if (!inRange(ny, nx, n)) {
            dir = flip(dir)
        } else {
            y = ny
            x = nx
        }
    }

    bw.write("$y $x")

    bw.flush()
}

private fun flip(dir: Int) = dir xor 1

private fun inRange(
    y: Int,
    x: Int,
    n: Int,
): Boolean = y in 1..n && x in 1..n

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
