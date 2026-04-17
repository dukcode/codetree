package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-use-functions-to-determine-sums-and-decimals/description">LINK</a>
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    bw.write(countMatchingBetween(a, b).toString())

    bw.flush()
}

private fun countMatchingBetween(
    frIn: Int,
    toIn: Int,
): Int =
    (frIn..toIn).count {
        it.isPrime() && it.hasEvenDigitSum()
    }

private fun Int.isPrime(): Boolean {
    if (this < 2) {
        return false
    }

    var i = 2
    while (i * i <= this) {
        if (this % i == 0) {
            return false
        }

        i++
    }

    return true
}

private fun Int.hasEvenDigitSum(): Boolean {
    var digitSum = 0
    var number = this
    while (number > 0) {
        digitSum += number % 10
        number /= 10
    }

    return digitSum % 2 == 0
}
