package org.dukcode.ps.codetree.trail02.chapter04.lesson04.introTotalWidthOfARectangle2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val OFFSET = 100

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-total-width-of-a-rectangle2/description">LINK</a>
 */
fun main() {
    val board =
        Array(2 * OFFSET + 1) {
            IntArray(2 * OFFSET + 1)
        }

    val n = br.readLine().toInt()
    repeat(n) {
        val (x1, y1, x2, y2) = parseInts()

        for (y in minOf(y1, y2) until maxOf(y1, y2)) {
            for (x in minOf(x1, x2) until maxOf(x1, x2)) {
                board[y + OFFSET][x + OFFSET] = 1
            }
        }
    }

    bw.write(board.sumOf { it.sum() }.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
