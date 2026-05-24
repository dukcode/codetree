package org.dukcode.ps.codetree.trail02.chapter06.lesson02.introElementalMeanValueForAParticularInterval

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-elemental-mean-value-for-a-particular-interval/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val arr = parseInts()

    var cnt = 0
    for (frIn in 0 until n) {
        for (toEx in frIn until n) {
            if (hasAvg(arr, frIn, toEx)) {
                cnt++
            }
        }
    }

    bw.write(cnt.toString())

    bw.flush()
}

private fun hasAvg(
    arr: IntArray,
    frIn: Int,
    toEx: Int,
): Boolean {
    val n = toEx - frIn + 1
    val sum = (frIn..toEx).sumOf { arr[it] }
    val avg = sum / n
    val remain = sum % n

    if (remain != 0) {
        return false
    }

    return (frIn..toEx).any { arr[it] == avg }
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
