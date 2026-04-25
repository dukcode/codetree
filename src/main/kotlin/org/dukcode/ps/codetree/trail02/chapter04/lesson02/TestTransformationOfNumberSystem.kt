package org.dukcode.ps.codetree.trail02.chapter04.lesson02.testTransformationOfNumberSystem

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-transformation-of-number-system/description">LINK</a>
 */
fun main() {
    val (a, b) = parseInts()
    val n = br.readLine()

    bw.write(n.changeBase(a, b))

    bw.flush()
}

private fun String.changeBase(
    fromRadix: Int,
    toRadix: Int,
): String {
    if (this == "0") {
        return this
    }

    var value = this.fold(0) { acc, c -> acc * fromRadix + (c - '0') }

    val digits =
        buildString {
            while (value > 0) {
                append(value % toRadix)
                value /= toRadix
            }
        }

    return digits.reversed()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
