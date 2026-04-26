package org.dukcode.ps.codetree.trail02.chapter05.lesson01.introContinuousNumber2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-continuous-number2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val arr =
        IntArray(n) {
            br.readLine().toInt()
        }

    var maxCnt = 0
    var cnt = 0
    for (idx in arr.indices) {
        if (idx == 0 || arr[idx - 1] != arr[idx]) {
            maxCnt = maxOf(maxCnt, cnt)
            cnt = 1
            continue
        }

        if (arr[idx - 1] == arr[idx]) {
            cnt++
        }
    }

    maxCnt = maxOf(maxCnt, cnt)

    bw.write(maxCnt.toString())

    bw.flush()
}
