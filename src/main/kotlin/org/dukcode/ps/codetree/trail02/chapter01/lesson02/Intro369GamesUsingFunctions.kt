package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-369-games-using-functions/description">LINK</a>
 */
fun main() {
    val st = StringTokenizer(br.readLine())

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    bw.write(count369(a, b).toString())

    bw.flush()
}

private fun count369(
    frIn: Int,
    toIn: Int,
): Int {
    var ret = 0
    for (num in frIn..toIn) {
        if (has369(num) || num % 3 == 0) {
            ret++
        }
    }

    return ret
}

fun has369(num: Int): Boolean {
    var value = num
    while (value > 0) {
        val digit = value % 10

        if (digit == 3 || digit == 6 || digit == 9) {
            return true
        }

        value /= 10
    }

    return false
}
