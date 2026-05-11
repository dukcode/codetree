package org.dukcode.ps.codetree.trail02.chapter06.lesson01.introPairParentheses3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-pair-parentheses-3/description">LINK</a>
 */
fun main() {
    val brackets = br.readLine()

    var cntPair = 0
    var cntOpen = 0
    for (bracket in brackets) {
        if (bracket == '(') {
            cntOpen++
            continue
        }

        cntPair += cntOpen
    }

    bw.write(cntPair.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
