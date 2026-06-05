package org.dukcode.ps.codetree.trail02.chapter06.lesson02.challengeCandyInTheBasket2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val MX = 100

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-candy-in-the-basket-2/description">LINK</a>
 */
fun main() {
    val (n, k) = parseInts()

    val arr = IntArray(MX + 1)
    repeat(n) {
        val (cnt, idx) = parseInts()

        arr[idx] += cnt
    }

    val maxRangeCnt =
        (0..MX).maxOf { pivot ->
            ((pivot - k)..(pivot + k)).sumOf { idx ->
                if (idx in 0..MX) arr[idx] else 0
            }
        }

    bw.write(maxRangeCnt.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
