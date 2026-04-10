package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-two-numbers-of-squares/description">LINK</a>
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    bw.write(power(a, b).toString())

    bw.flush()
}

fun power(
    a: Int,
    b: Int,
): Int {
    var ret = 1
    repeat(b) {
        ret *= a
    }

    return ret
}
