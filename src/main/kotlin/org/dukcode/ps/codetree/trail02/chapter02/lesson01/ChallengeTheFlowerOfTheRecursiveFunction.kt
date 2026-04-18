package org.dukcode.ps.codetree.trail02.chapter02.lesson01.challengeTheFlowerOfTheRecursiveFunction

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-flower-of-the-recursive-function/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    printNums(n)

    bw.flush()
}

private fun printNums(n: Int) {
    if (n == 0) {
        return
    }

    bw.write("$n ")

    printNums(n - 1)

    bw.write("$n ")
}
