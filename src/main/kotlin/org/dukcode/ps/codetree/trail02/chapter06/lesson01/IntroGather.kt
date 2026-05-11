package org.dukcode.ps.codetree.trail02.chapter06.lesson01.introGather

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.abs

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-gather/description">LINK</a>
 */
fun main() {
    skipLine()
    val arr = parseInts()

    val minSumDist =
        arr.indices.minOf { pivotIdx ->
            arr.withIndex().sumOf { (idx, cnt) ->
                abs(pivotIdx - idx) * cnt
            }
        }

    bw.write(minSumDist.toString())

    bw.flush()
}

private fun skipLine() = br.readLine()

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
