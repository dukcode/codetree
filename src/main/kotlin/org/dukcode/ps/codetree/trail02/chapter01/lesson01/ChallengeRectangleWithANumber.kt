package org.dukcode.ps.codetree.trail02.chapter01.lesson01

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see [LINK](https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rectangle-with-a-number/description)
 */
fun main() {
    val size = br.readLine().toInt()

    printSquare(size)

    bw.flush()
}

fun printSquare(size: Int) {
    var i = 0
    repeat(size) {
        repeat(size) {
            i = i % 9 + 1
            bw.write(i.toString())
            bw.write(' '.code)
        }
        bw.newLine()
    }
}
