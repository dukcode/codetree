package org.dukcode.ps.codetree.trail02.chapter01.lesson03.challengeFindTheAbsoluteValue

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.abs

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-the-absolute-value/description">LINK</a>
 */
fun main() {
    skipLine()
    val arr = parseInts()

    arr.applyAbs()

    bw.write(arr.joinToString(" "))

    bw.flush()
}

private fun IntArray.applyAbs() {
    for ((idx, e) in withIndex()) {
        this[idx] = abs(e)
    }
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }

private fun skipLine() = br.readLine()
