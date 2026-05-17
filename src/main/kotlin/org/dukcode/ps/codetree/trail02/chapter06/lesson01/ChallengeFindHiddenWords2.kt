package org.dukcode.ps.codetree.trail02.chapter06.lesson01.challengeFindHiddenWords2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dy = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
private val dx = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-hidden-words-2/description">LINK</a>
 */
fun main() {
    val (h, w) = parseInts()
    val board = Array(h) { br.readLine() }

    val ans =
        (0 until h).sumOf { y ->
            (0 until w).sumOf { x ->
                countLee(board, y, x)
            }
        }

    bw.write(ans.toString())

    bw.flush()
}

private fun countLee(
    board: Array<String>,
    y: Int,
    x: Int,
): Int {
    val h = board.size
    val w = board[0].length

    if (board[y][x] != 'L') {
        return 0
    }

    return (0 until 8).count { dir ->
        (1..2).all { dist ->
            val ny = y + dy[dir] * dist
            val nx = x + dx[dir] * dist
            if (ny !in 0 until h || nx !in 0 until w) {
                return@all false
            }

            return@all board[ny][nx] == 'E'
        }
    }
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
