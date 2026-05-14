package org.dukcode.ps.codetree.trail02.chapter06.lesson01.introBestPlaceOf13

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-best-place-of-13/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val board =
        Array(n) {
            parseInts()
        }

    val maxCnt =
        (0 until n).maxOf { y ->
            (0 until n).maxOf { x ->
                (0 until 3).sumOf { dx -> if (x + dx < n) board[y][x + dx] else 0 }
            }
        }

    bw.write(maxCnt.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
