package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sum-from-1-to-a-certain-number/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    var sum = 0
    for (num in 1..n) {
        sum += num
    }

    val result = sum / 10

    bw.write(result.toString())

    bw.flush()
}
