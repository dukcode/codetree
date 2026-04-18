package org.dukcode.ps.codetree.trail02.chapter03.lesson01.challengeGroupOfPairs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-group-of-pairs/description">LINK</a>
 */
fun main() {
    skipLine()
    val arr = parseInts()
    bw.write(calc(arr).toString())
    bw.flush()
}

fun calc(arr: IntArray): Int {
    arr.sort()

    var maxPairSum = 0
    val lastIndex = arr.lastIndex

    for (i in 0..<(arr.size / 2)) {
        maxPairSum = maxOf(maxPairSum, arr[i] + arr[lastIndex - i])
    }

    return maxPairSum
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }

private fun skipLine() = br.readLine()
