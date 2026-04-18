package org.dukcode.ps.codetree.trail02.chapter01.lesson03

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-divide-even-numbers-by-2/description">LINK</a>
 */
fun main() {
    skipLine()
    val arr = parseInts()

    arr.divideEvenBy2()

    arr.forEach {
        bw.write(it.toString())
        bw.write(' '.code)
    }

    bw.flush()
}

private fun IntArray.divideEvenBy2() {
    for (idx in indices) {
        if (this[idx] % 2 == 0) {
            this[idx] /= 2
        }
    }
}

private fun IntArray.divideEvenBy2Lambda() =
    forEachIndexed { idx, e ->
        if (e % 2 == 0) {
            this[idx] /= 2
        }
    }

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }

private fun skipLine() = br.readLine()
