package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-determining-the-whole-number-using-a-function/description">LINK</a>
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    bw.write(countWholeNumber(a, b).toString())

    bw.flush()
}

private fun countWholeNumber(
    frIn: Int,
    toIn: Int,
): Int =
    (frIn..toIn)
        .count { isWholeNumber(it) }

private fun isWholeNumber(num: Int): Boolean =
    num % 2 != 0 &&
        num % 10 != 5 &&
        (num % 3 != 0 || num % 9 == 0)
