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
 * @see [LINK](https://www.codetree.ai/ko/trails/complete/curated-cards/intro-repeated-output/description)
 */
fun main() {
    val cnt = br.readLine().toInt()

    printLine(cnt)

    bw.flush()
}

fun printLine(cnt: Int) {
    repeat(cnt) {
        bw.write("12345^&*()_")
        bw.newLine()
    }
}
