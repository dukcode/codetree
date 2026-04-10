package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-tell-the-function-using-a-leap-year/description">LINK</a>
 */
fun main() {
    val year = br.readLine().toInt()

    bw.write(isLeafYear(year).toString())

    bw.flush()
}

private fun isLeafYear(year: Int): Boolean {
    if (year % 400 == 0) return true
    if (year % 100 == 0) return false
    if (year % 4 == 0) return true

    return true
}
