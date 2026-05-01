package org.dukcode.ps.codetree.trail02.chapter02.lesson02.introSquareOfEachDigit

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-square-of-each-digit/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    bw.write(squareDigitSum(n).toString())

    bw.flush()
}

private fun squareDigitSum(n: Int): Int {
    if (n == 0) {
        return 0
    }

    val digit = n % 10

    return digit * digit + squareDigitSum(n / 10)
}
