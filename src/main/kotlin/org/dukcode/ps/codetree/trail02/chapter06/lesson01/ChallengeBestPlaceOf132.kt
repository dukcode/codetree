package org.dukcode.ps.codetree.trail02.chapter06.lesson01.challengeBestPlaceOf132

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.abs

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-best-place-of-13-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val board = Array(n) { parseInts() }

    val ans =
        (0 until n).maxOf { y1 ->
            (0 until n - 2).maxOf { x1 ->
                (0 until n).maxOf { y2 ->
                    (0 until n - 2).maxOf { x2 ->
                        if (isOverlapped(y1, x1, y2, x2)) {
                            -1
                        } else {
                            blockSum(board, y1, x1) + blockSum(board, y2, x2)
                        }
                    }
                }
            }
        }

    bw.write(ans.toString())

    bw.flush()
}

private fun blockSum(
    board: Array<IntArray>,
    y: Int,
    x: Int,
): Int = (0 until 3).sumOf { dx -> board[y][x + dx] }

private fun isOverlapped(
    y1: Int,
    x1: Int,
    y2: Int,
    x2: Int,
): Boolean = y1 == y2 && abs(x1 - x2) < 3

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
