package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-an-even-number-with-a-multiple-of-5-in-the-sum/description">LINK</a>
 */
fun main() {
    val num = br.readLine().toInt()
    bw.write(if (isMagicNumber(num)) "Yes" else "No")

    bw.flush()
}

private fun isMagicNumber(num: Int): Boolean = num % 2 == 0 && digitSum(num) % 5 == 0

private fun digitSum(num: Int): Int {
    var ret = 0

    var value = num
    while (value > 0) {
        ret += value % 10
        value /= 10
    }

    return ret
}

/*
fun digitSum2(num: Int): Int = generateSequence(num) { it / 10 }
        .takeWhile { it > 0 }
        .sumOf { it % 10 }
*/
