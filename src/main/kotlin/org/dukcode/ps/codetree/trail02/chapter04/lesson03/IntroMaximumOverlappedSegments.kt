package org.dukcode.ps.codetree.trail02.chapter04.lesson03.introMaximumOverlappedSegments

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val MX = 100

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-maximum-overlapped-segments/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val arr = IntArray(2 * MX + 1)
    var mx = 0
    repeat(n) {
        val (frIn, toIn) = parseInts()

        for (idx in frIn until toIn) {
            arr[idx + MX]++
            mx = maxOf(mx, arr[idx + MX])
        }
    }

    bw.write(mx.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
