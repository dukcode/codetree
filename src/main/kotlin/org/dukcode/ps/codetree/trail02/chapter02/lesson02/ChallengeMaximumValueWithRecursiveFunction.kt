package org.dukcode.ps.codetree.trail02.chapter02.lesson02.challengeMaximumValueWithRecursiveFunction

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-value-with-recursive-function/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val arr = parseInts()

    bw.write(arr.max(0, n).toString())

    bw.flush()
}

private fun IntArray.max(
    frIn: Int,
    toEx: Int,
): Int {
    val size = toEx - frIn
    if (size == 1) {
        return this[frIn]
    }

    val mid = (frIn + toEx) / 2

    return maxOf(this.max(frIn, mid), this.max(mid, toEx))
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }

private fun skipLine() = br.readLine()
