package org.dukcode.ps.codetree.trail02.chapter05.lesson03.challengeShootALaserInTheMirror2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val RIGHT_UPPER = 0
private const val LEFT_LOWER = 1

// S, W, N, E
private const val S = 0
private const val W = 1
private const val N = 2
private const val E = 3
private val dy = intArrayOf(1, 0, -1, 0)
private val dx = intArrayOf(0, -1, 0, 1)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-shoot-a-laser-in-the-mirror-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val board =
        Array(n) {
            val line = br.readLine()
            IntArray(n) {
                if (line[it] == '/') RIGHT_UPPER else LEFT_LOWER
            }
        }

    val k = br.readLine().toInt() - 1

    var (y, x, dir) = init(n, k)

    var cnt = 0
    while (y in 0 until n && x in 0 until n) {
        dir = dir.reflect(board[y][x])
        y += dy[dir]
        x += dx[dir]
        cnt++
    }

    bw.write(cnt.toString())

    bw.flush()
}

private fun Int.reflect(block: Int): Int {
    if (block == RIGHT_UPPER) {
        when (this) {
            S -> return W
            W -> return S
            N -> return E
            E -> return N
        }
    }

    // LEFT_LOWER
    return when (this) {
        S -> E
        W -> N
        N -> W
        E -> S
        else -> throw IllegalStateException()
    }
}

private fun init(
    n: Int,
    k: Int,
): Triple<Int, Int, Int> {
    val side = k / n
    val offset = k % n

    return when (side) {
        0 -> Triple(0, offset, side)
        1 -> Triple(offset, n - 1, side)
        2 -> Triple(n - 1, n - 1 - offset, side)
        else -> Triple(n - 1 - offset, 0, side)
    }
}
