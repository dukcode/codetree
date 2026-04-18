package org.dukcode.ps.codetree.trail02.chapter02.lesson02.introUntilTheMomentIReachOne

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-until-the-moment-I-reach-one/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    bw.write(countOperation(n).toString())

    bw.flush()
}

fun countOperation(n: Int): Int {
    if (n == 1) {
        return 0
    }

    val next =
        if (n % 2 == 0) {
            n / 2
        } else {
            n / 3
        }

    return 1 + countOperation(next)
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
