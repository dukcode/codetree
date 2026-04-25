package org.dukcode.ps.codetree.trail02.chapter04.lesson03.testStrangeFlippingTiles

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val OFFSET = 100_000

private const val NONE = -1
private const val WHITE = 0
private const val BLACK = 1

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-strange-flipping-tiles/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val arr = IntArray(2 * OFFSET + 1) { NONE }

    var pos = 0
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val cnt = st.nextToken().toInt() - 1
        val dir = st.nextToken()

        val step = if (dir == "L") -1 else 1
        val color = if (dir == "L") WHITE else BLACK

        arr[pos + OFFSET] = color
        repeat(cnt) {
            pos += step
            arr[pos + OFFSET] = color
        }
    }

    val cntWhite = arr.count { it == WHITE }
    val cntBlack = arr.count { it == BLACK }

    bw.write("$cntWhite $cntBlack")

    bw.flush()
}
