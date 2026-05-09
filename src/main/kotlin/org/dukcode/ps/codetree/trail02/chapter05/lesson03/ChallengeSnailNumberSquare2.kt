package org.dukcode.ps.codetree.trail02.chapter05.lesson03.challengeSnailNumberSquare2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

// DOWN, RIGHT, UP, LEFT
private val dy = intArrayOf(1, 0, -1, 0)
private val dx = intArrayOf(0, 1, 0, -1)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-snail-number-square-2/description">LINK</a>
 */
fun main() {
    val (h, w) = parseInts()

    val board = Array(h) { IntArray(w) }

    var y = 0
    var x = 0
    var dir = 0
    repeat(h * w) {
        board[y][x] = it + 1

        val ny = y + dy[dir]
        val nx = x + dx[dir]

        if (ny !in 0 until h || nx !in 0 until w || board[ny][nx] != 0) {
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
