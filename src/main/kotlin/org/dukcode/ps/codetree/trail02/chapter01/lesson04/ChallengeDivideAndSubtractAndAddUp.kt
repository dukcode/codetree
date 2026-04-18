package org.dukcode.ps.codetree.trail02.chapter01.lesson04.challengeDivideAndSubtractAndAddUp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-divide-and-subtract-and-add-up/description">LINK</a>
 */
fun main() {
    val (_, m) = parseInts()
    val arr = parseInts()

    bw.write(calc(m, arr).toString())

    bw.flush()
}

private fun calc(
    m: Int,
    arr: IntArray,
): Int {
    var idx = m
    var ret = arr[idx - 1]

    while (idx != 1) {
        if (idx % 2 == 0) {
            idx /= 2
        } else {
            idx--
        }

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
