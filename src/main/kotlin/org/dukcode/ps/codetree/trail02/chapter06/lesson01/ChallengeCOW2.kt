package org.dukcode.ps.codetree.trail02.chapter06.lesson01.challengeCOW2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-c-o-w-2/description">LINK</a>
 */
fun main() {
    skipLine()
    val word = br.readLine()

    var cntC = 0
    var cntO = 0
    var ans = 0
    for (c in word) {
        if (c == 'C') cntC++
        if (c == 'O') cntO += cntC
        if (c == 'W') ans += cntO
    }

    bw.write(ans.toString())

    bw.flush()
}

private fun skipLine() = br.readLine()
