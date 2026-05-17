package org.dukcode.ps.codetree.trail02.chapter06.lesson01.challengeEscapingCarry2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-escaping-carry-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val arr = IntArray(n) { br.readLine().toInt() }

    var maxSum = -1
    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                if (hasCarry(arr[i], arr[j], arr[k])) {
                    continue
                }

                maxSum = maxOf(maxSum, arr[i] + arr[j] + arr[k])
            }
        }
    }

    bw.write(maxSum.toString())

    bw.flush()
}

private fun hasCarry(
    a: Int,
    b: Int,
    c: Int,
): Boolean {
    var x = a
    var y = b
    var z = c
    while (x != 0 || y != 0 || z != 0) {
        val digitSum = x % 10 + y % 10 + z % 10

        if (digitSum >= 10) {
            return true
        }

        x /= 10
        y /= 10
        z /= 10
    }

    return false
}
