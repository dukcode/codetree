package org.dukcode.ps.codetree.trail02.chapter01.lesson04.testSumOfSpecificIntervals

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-sum-of-specific-intervals/description">LINK</a>
 */
fun main() {
    val (_, m) = parseInts()
    val arr = parseInts()

    repeat(m) {
        val (frIn, toIn) = parseInts()

        bw.write(sum(arr, frIn, toIn).toString())
        bw.newLine()
    }

    bw.flush()
}

private fun sum(
    arr: IntArray,
    frIn: Int,
    toIn: Int,
): Int {
    var ret = 0
    for (idx in frIn..toIn) {
        ret += arr[idx - 1]
    }

    return ret
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
