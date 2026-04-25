package org.dukcode.ps.codetree.trail02.chapter04.lesson04.introAreaOfNonOverlappingRectangle

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val OFFSET = 1_000

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-area-of-non-overlapping-rectangle/description">LINK</a>
 */
fun main() {
    val board =
        Array(2 * OFFSET + 1) {
            IntArray(2 * OFFSET + 1)
        }

    for (i in 0 until 3) {
        val color = if (i == 2) 0 else 1

        val (x1, y1, x2, y2) = parseInts()

        for (y in y1 until y2) {
            for (x in x1 until x2) {
                board[y + OFFSET][x + OFFSET] = color
            }
        }
    }

    bw.write(board.sumOf(IntArray::sum).toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
