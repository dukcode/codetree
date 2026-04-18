package org.dukcode.ps.codetree.trail02.chapter02.lesson02.testLeastCommonMultipleUsingRecursiveFunction

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-least-common-multiple-using-recursive-function/description">LINK</a>
 */
fun main() {
    skipLine()
    val arr = parseInts()

    bw.write(arr.lcm().toString())

    bw.flush()
}

private fun IntArray.lcm() = this.lcm(0, size)

private fun IntArray.lcm(
    frIn: Int,
    toEx: Int,
): Int {
    if (toEx - frIn == 1) {
        return this[frIn]
    }

    val next = this.lcm(frIn + 1, toEx)

    return this[frIn] * next / gcd(this[frIn], next)
}

private fun gcd(
    a: Int,
    b: Int,
): Int {
    if (b == 0) {
        return a
    }

    if (a < b) {
        return gcd(b, a)
    }

    return gcd(b, a % b)
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }

private fun skipLine() = br.readLine()
