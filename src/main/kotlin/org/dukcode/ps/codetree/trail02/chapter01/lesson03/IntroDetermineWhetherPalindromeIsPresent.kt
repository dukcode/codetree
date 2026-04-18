package org.dukcode.ps.codetree.trail02.chapter01.lesson03

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-determine-whether-palindrome-is-present/description">LINK</a>
 */
fun main() {
    val str = br.readLine()

    bw.write(if (str.isPalindrome()) "Yes" else "No")

    bw.flush()
}

private fun String.isPalindrome(): Boolean {
    var idx = 0
    while (idx < length / 2) {
        if (this[idx] != this[length - 1 - idx]) {
            return false
        }

        idx++
    }

    return true
}

private fun String.isPalindrome2(): Boolean {
    for (idx in 0..<(length / 2)) {
        if (this[idx] != this[length - 1 - idx]) {
            return false
        }
    }
    return true
}
