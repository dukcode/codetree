package org.dukcode.ps.codetree.trail02.chapter06.lesson01.challengePairParentheses2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-pair-parentheses-2/description">LINK</a>
 */
fun main() {
    val pairs = br.readLine()

    var cntOpen = 0
    var ans = 0
    pairs.indices.zipWithNext { prevIdx, currIdx ->
        val prev = pairs[prevIdx]
        val curr = pairs[currIdx]

        when {
            prev == '(' && curr == '(' -> cntOpen++
            prev == ')' && curr == ')' -> ans += cntOpen
        }

        Unit
    }

    bw.write(ans.toString())

    bw.flush()
}
