package org.dukcode.ps.codetree.trail02.chapter06.lesson01.challengeOMok

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val SIZE = 19
private val dy = intArrayOf(0, 1, 1, 1)
private val dx = intArrayOf(1, 0, 1, -1)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-O-mok/description">LINK</a>
 */
fun main() {
    val board =
        Array(SIZE) {
            val st = StringTokenizer(br.readLine())
            IntArray(SIZE) {
                st.nextToken().toInt()
            }
        }

    var ans: Pair<Int, Int>? = null

    outer@ for (y in 0 until SIZE) {
        for (x in 0 until SIZE) {
            if (board[y][x] == 0) {
                continue
            }

            if (hasWon(board, y, x)) {
                ans = y to x
                break@outer
            }
        }
    }

    if (ans == null) {
        bw.write("0")
    } else {
        val (y, x) = ans

        bw.write(board[y][x].toString())
        bw.newLine()
        bw.write("${y + 1} ${x + 1}")
    }

    bw.flush()
}

private fun hasWon(
    board: Array<IntArray>,
    y: Int,
    x: Int,
): Boolean {
    val color = board[y][x]

    return (0 until 4).any { dir ->
        (-2..2).all { dist ->
            val ny = y + dy[dir] * dist
            val nx = x + dx[dir] * dist

            ny in 0 until SIZE && nx in 0 until SIZE && board[ny][nx] == color
        }
    }
}
