package org.dukcode.ps.codetree.trail02.chapter01.lesson03.challengeMoreThanOneAlphabet

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-more-than-one-alphabet/description">LINK</a>
 */
fun main() {
    val word = br.readLine()
    bw.write(if (word.hasMoreThanOneAlphabet()) "Yes" else "No")

    bw.flush()
}

private fun String.hasMoreThanOneAlphabet(): Boolean {
    for (c in this) {
        if (c != this.first()) {
            return true
        }
    }

    return false
}
