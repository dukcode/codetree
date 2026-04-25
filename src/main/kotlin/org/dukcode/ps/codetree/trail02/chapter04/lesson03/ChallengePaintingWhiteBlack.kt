package org.dukcode.ps.codetree.trail02.chapter04.lesson03.challengePaintingWhiteBlack

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
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-painting-white-black/description">LINK</a>
 */
fun main() {
    val counts = Array(2) { IntArray(2 * OFFSET + 1) }
    val status = IntArray(2 * OFFSET + 1) { NONE }

    val n = br.readLine().toInt()

    var pos = 0
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val dist = st.nextToken().toInt()
        val dir = if (st.nextToken() == "L") -1 else 1

        val color = if (dir == -1) WHITE else BLACK

        val nextPos = pos + (dist - 1) * dir

        val start = minOf(pos, nextPos)
        val end = maxOf(pos, nextPos)
        for (idx in start..end) {
            counts[color][idx + OFFSET]++
            status[idx + OFFSET] = color
        }

        pos = nextPos
    }

    val (numWhite, numBlack, numGray) = countColors(counts, status)

    bw.write("$numWhite $numBlack $numGray")

    bw.flush()
}

private fun countColors(
    counts: Array<IntArray>,
    status: IntArray,
): Triple<Int, Int, Int> {
    var numWhite = 0
    var numBlack = 0
    var numGray = 0
    for (idx in status.indices) {
        if (status[idx] == NONE) {
            continue
        }

        if (counts[WHITE][idx] >= 2 && counts[BLACK][idx] >= 2) {
            numGray++
            continue
        }

        if (status[idx] == WHITE) {
            numWhite++
        } else {
            numBlack++
        }
    }
    return Triple(numWhite, numBlack, numGray)
}
