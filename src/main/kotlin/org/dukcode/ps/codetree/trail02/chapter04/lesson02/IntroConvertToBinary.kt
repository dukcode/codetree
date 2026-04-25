package org.dukcode.ps.codetree.trail02.chapter04.lesson02.introConvertToBinary

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-convert-to-binary/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val binary = n.toBinaryString()

    bw.write(binary)

    bw.flush()
}

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
