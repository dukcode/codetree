package org.dukcode.ps.codetree.trail02.chapter04.lesson02.challengeVariousNumeralSystemTransformations

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-various-numeral-system-transformations/description">LINK</a>
 */
fun main() {
    val (n, b) = parseInts()

    bw.write(n.toString(b))

    bw.flush()
}

private fun Int.toString(radix: Int): String {
    if (this == 0) {
        return "0"
    }

    var value = this
    val digits =
        buildString {
            while (value > 0) {
                append(value % radix)
                value /= radix
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
