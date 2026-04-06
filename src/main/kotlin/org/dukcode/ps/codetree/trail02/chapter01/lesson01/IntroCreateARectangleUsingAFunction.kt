package org.dukcode.ps.codetree.trail02.chapter01.lesson01

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see [LINK](https://www.codetree.ai/ko/trails/complete/curated-cards/intro-create-a-rectangle-using-a-function/description)
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val h = st.nextToken().toInt()
    val w = st.nextToken().toInt()

    printNums(h, w)

    bw.flush()
}

fun printNums(
    h: Int,
    w: Int,
) {
    repeat(h) {
        repeat(w) {
            bw.write('1'.code)
        }
        bw.newLine()
    }
}
