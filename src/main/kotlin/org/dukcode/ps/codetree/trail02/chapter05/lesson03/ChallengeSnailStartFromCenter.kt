package org.dukcode.ps.codetree.trail02.chapter05.lesson03.challengeSnailStartFromCenter

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
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-snail-start-from-center/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val board = Array(n) { IntArray(n) }

    var y = n / 2
    var x = n / 2
    var dir = 0
    repeat(n * n) {
        board[y][x] = it + 1

        val nDir = (dir + 1) % 4
        val ny = y + dy[nDir]
        val nx = x + dx[nDir]

        if (ny !in 0 until n || nx !in 0 until n || board[ny][nx] == 0) {
            dir = nDir
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
