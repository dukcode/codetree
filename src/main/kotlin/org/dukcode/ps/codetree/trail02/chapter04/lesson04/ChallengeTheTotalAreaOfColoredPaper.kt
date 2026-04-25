package org.dukcode.ps.codetree.trail02.chapter04.lesson04.challengeTheTotalAreaOfColoredPaper

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val OFFSET = 100
private const val PAPER_SIZE = 8

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-total-area-of-colored-paper/description">LINK</a>
 */
fun main() {
    val board =
        Array(2 * OFFSET + 1) {
            IntArray(2 * OFFSET + 1)
        }

    val n = br.readLine().toInt()
    repeat(n) {
        val (x1, y1) = parseInts()
        for (y in y1 until y1 + PAPER_SIZE) {
            for (x in x1 until x1 + PAPER_SIZE) {
                board[y + OFFSET][x + OFFSET] = 1
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
