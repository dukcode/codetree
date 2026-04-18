package org.dukcode.ps.codetree.trail02.chapter01.lesson05.introToOutputNumerically

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-to-output-numerically/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    printAscending(n)
    bw.newLine()

    printDescending(n)
    bw.newLine()

    bw.flush()
}

fun printDescending(n: Int) {
    if (n == 0) {
        return
    }

    bw.write(n.toString())
    bw.write(' '.code)

    printDescending(n - 1)
}

fun printAscending(n: Int) {
    if (n == 0) {
        return
    }

    printAscending(n - 1)

    bw.write(n.toString())
    bw.write(' '.code)
}
