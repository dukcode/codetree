package org.dukcode.ps.codetree.trail02.chapter03.lesson01.introSortingWords

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sorting-words/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val words =
        MutableList(n) { br.readLine() }.apply { sort() }

    for (word in words) {
        bw.write(word)
        bw.newLine()
    }

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
