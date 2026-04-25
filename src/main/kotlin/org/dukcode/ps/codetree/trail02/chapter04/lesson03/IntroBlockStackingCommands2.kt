package org.dukcode.ps.codetree.trail02.chapter04.lesson03.introBlockStackingCommands2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-block-stacking-commands2/description">LINK</a>
 */
fun main() {
    val (n, k) = parseInts()

    val arr = IntArray(n)
    repeat(k) {
        val (frIn, toIn) = parseInts().map { i -> i - 1 }
        for (idx in frIn..toIn) {
            arr[idx]++
        }
    }

    bw.write(arr.maxOrNull().toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
