package org.dukcode.ps.codetree.trail02.chapter02.lesson02.challenge3nPlus1SequenceWithRecursiveFunction

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-3n-plus-1-sequence-with-recursive-function/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    bw.write(countCollatzSteps(n).toString())

    bw.flush()
}

private fun countCollatzSteps(n: Int): Int {
    if (n == 1) {
        return 0
    }

    return if (n.isEven()) {
        1 + countCollatzSteps(n / 2)
    } else {
        1 + countCollatzSteps(n * 3 + 1)
    }
}

private fun Int.isEven(): Boolean = this % 2 == 0
