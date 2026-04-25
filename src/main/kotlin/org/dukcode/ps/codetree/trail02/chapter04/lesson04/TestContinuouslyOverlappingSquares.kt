package org.dukcode.ps.codetree.trail02.chapter04.lesson04.testContinuouslyOverlappingSquares

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val OFFSET = 100

private const val RED = 1
private const val BLUE = 2

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-continuously-overlapping-squares/description">LINK</a>
 */
fun main() {
    val board =
        Array(2 * OFFSET + 1) {
            IntArray(2 * OFFSET + 1)
        }

    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val color = if (i % 2 == 0) RED else BLUE
        val r = parseRectangle()
        fill(board, r, color)
    }

    bw.write(board.sumOf { line -> line.count { it == BLUE } }.toString())
    bw.flush()
}

private fun fill(
    board: Array<IntArray>,
    rectangle: Rectangle,
    color: Int,
) {
    for (y in rectangle.y1 until rectangle.y2) {
        for (x in rectangle.x1 until rectangle.x2) {
            board[y + OFFSET][x + OFFSET] = color
        }
    }
}

private data class Rectangle(
    val x1: Int,
    val y1: Int,
    val x2: Int,
    val y2: Int,
)

private fun parseRectangle(): Rectangle {
    val arr =
        StringTokenizer(br.readLine()).run {
            IntArray(countTokens()) {
                nextToken().toInt()
            }
        }

    return Rectangle(arr[0], arr[1], arr[2], arr[3])
}
