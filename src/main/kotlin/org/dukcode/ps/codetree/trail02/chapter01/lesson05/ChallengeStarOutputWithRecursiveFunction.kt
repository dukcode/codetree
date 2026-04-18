package org.dukcode.ps.codetree.trail02.chapter01.lesson05.challengeStarOutputWithRecursiveFunction

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-star-output-with-recursive-function/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    printStars(n)

    bw.flush()
}

private fun printStars(n: Int) {
    if (n == 0) {
        return
    }

    printStars(n - 1)

    bw.write("*".repeat(n))
    bw.newLine()
}
