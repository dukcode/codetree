package org.dukcode.ps.codetree.trail02.chapter01.lesson03.introToExchangeTwoIntegerValues

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-to-exchange-two-integer-values/description">LINK</a>
 */
fun main() {
    val (a, b) = pareInts().map { IntWrapper(it) }

    swap(a, b)

    bw.write("${a.value} ${b.value}")
    bw.newLine()

    bw.flush()
}

private fun swap(
    a: IntWrapper,
    b: IntWrapper,
) {
    val temp = a.value
    a.value = b.value
    b.value = temp
}

private fun pareInts(): IntArray =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) { nextToken().toInt() }
    }

private class IntWrapper(
    var value: Int,
)
