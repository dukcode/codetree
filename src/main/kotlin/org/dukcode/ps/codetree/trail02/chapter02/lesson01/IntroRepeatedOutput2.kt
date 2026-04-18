package org.dukcode.ps.codetree.trail02.chapter02.lesson01.introRepeatedOutput2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-repeated-output-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    printHelloWorld(n)

    bw.flush()
}

fun printHelloWorld(n: Int) {
    if (n == 0) {
        return
    }

    bw.write("HelloWorld")
    bw.newLine()

    printHelloWorld(n - 1)
}
