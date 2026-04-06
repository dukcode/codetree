package org.dukcode.ps.codetree.trail02.chapter01.lesson01

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var st: StringTokenizer? = null

/**
 * @see [LINK](https://www.codetree.ai/ko/trails/complete/curated-cards/intro-repeat-shooting-the-stars-five-times/description)
 */
fun main() {
    repeat(5) {
        bw.write(createRow(10))
        bw.newLine()
    }

    bw.flush()
}

private fun createRow(col: Int): String =
    buildString {
        repeat(col) {
            append("*")
        }
    }
