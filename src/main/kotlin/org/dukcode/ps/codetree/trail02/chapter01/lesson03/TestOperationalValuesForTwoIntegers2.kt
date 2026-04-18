package org.dukcode.ps.codetree.trail02.chapter01.lesson03.testOperationalValuesForTwoIntegers2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-operational-values-for-two-integers-2/description">LINK</a>
 */
fun main() {
    val (a, b) = parseInts().map(::IntWrapper)

    operate(a, b)

    bw.write("$a $b")

    bw.flush()
}

private fun operate(
    a: IntWrapper,
    b: IntWrapper,
) {
    val min = minOf(a, b)
    val max = maxOf(a, b)

    min.value += 10
    max.value *= 2
}

private class IntWrapper(
    var value: Int,
) : Comparable<IntWrapper> {
    override fun compareTo(other: IntWrapper): Int = value.compareTo(other.value)

    override fun toString(): String = value.toString()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
