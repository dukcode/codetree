package org.dukcode.ps.codetree.trail02.chapter04.lesson02.challengeDecimalAndBinaryNumber2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-decimal-and-binary-number-2/description">LINK</a>
 */
fun main() {
    val binary = br.readLine()

    bw.write((binary.toDecimal() * 17).toBinaryString())

    bw.flush()
}

private fun String.toDecimal(): Int = this.fold(0) { acc, c -> acc * 2 + (c - '0') }

private fun Int.toBinaryString(): String {
    if (this == 0) {
        return "0"
    }

    var value = this
    val digits =
        buildString {
            while (value > 0) {
                append(value % 2)
                value /= 2
            }
        }

    return digits.reversed()
}
