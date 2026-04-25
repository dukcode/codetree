package org.dukcode.ps.codetree.trail02.chapter04.lesson03.challengeAreaBeenToAndFrom2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val OFFSET = 1_000

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-area-been-to-and-from2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    var pos = 0
    val segments = IntArray(2 * OFFSET + 1)

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val dist = st.nextToken().toInt()
        val dir = if (st.nextToken() == "L") -1 else 1

        val nextPos = pos + dist * dir

        val start = minOf(pos, nextPos)
        val end = maxOf(pos, nextPos)
        for (x in start until end) {
            segments[x + OFFSET]++
        }

        pos = nextPos
    }

    bw.write(segments.count { it >= 2 }.toString())

    bw.flush()
}
