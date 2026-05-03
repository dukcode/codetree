package org.dukcode.ps.codetree.trail02.chapter05.lesson03.introSnailNumberSquare

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

// R, D, L, U
private val dy = intArrayOf(0, 1, 0, -1)
private val dx = intArrayOf(1, 0, -1, 0)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-snail-number-square/description">LINK</a>
 */
fun main() {
    val (h, w) = parseInts()

    val board = Array(h) { IntArray(w) }

    fun canFillNext(
        y: Int,
        x: Int,
        dir: Int,
    ): Boolean {
        val ny = y + dy[dir]
        val nx = x + dx[dir]

        return ny in 0 until h && nx in 0 until w && board[ny][nx] == 0
    }

    var y = 0
    var x = 0
    var dir = 0
    for (num in 1..h * w) {
        board[y][x] = num

        if (!canFillNext(y, x, dir)) {
            dir = (dir + 1) % 4
        }

        y += dy[dir]
        x += dx[dir]
    }

    bw.write(board.joinToString("\n") { it.joinToString(" ") })

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
