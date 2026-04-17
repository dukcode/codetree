package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-to-determine-whether-a-continuous-subsequence-is-made-using-a-function/description">LINK</a>
 */
fun main() {
    skipLine()
    val arr1 = parseInts()
    val arr2 = parseInts()

    bw.write(if (arr2.isContinuousSubsequenceOf(arr1)) "Yes" else "No")
    bw.flush()
}

private fun IntArray.isContinuousSubsequenceOf(other: IntArray): Boolean {
    if (size > other.size) return false

    val lastStart = other.size - size
    for (start in 0..lastStart) {
        var matches = true

        for (offset in indices) {
            if (this[offset] != other[start + offset]) {
                matches = false
                break
            }
        }

        if (matches) return true
    }

    return false
}

private fun parseInts(): IntArray {
    val st = StringTokenizer(br.readLine())
    return IntArray(st.countTokens()) { st.nextToken().toInt() }
}

private fun skipLine() {
    br.readLine()
}
