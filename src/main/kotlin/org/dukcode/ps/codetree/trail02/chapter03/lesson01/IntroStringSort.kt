package org.dukcode.ps.codetree.trail02.chapter03.lesson01.introStringSort

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-string-sort/description">LINK</a>
 */
fun main() {
    val str = br.readLine()

    bw.write(str.sorted())

    bw.flush()
}

fun String.sorted(): String = String(toCharArray().apply { sort() })
