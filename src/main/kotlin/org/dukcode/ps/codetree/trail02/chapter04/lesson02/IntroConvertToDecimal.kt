package org.dukcode.ps.codetree.trail02.chapter04.lesson02.introConvertToDecimal

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-convert-to-decimal/description">LINK</a>
 */
fun main() {
    val binary = br.readLine()

    bw.write(binary.toDecimal().toString())

    bw.flush()
}

private fun String.toDecimal(): Int =
    this.fold(0) { acc, c ->
        2 * acc + (c - '0')
    }
