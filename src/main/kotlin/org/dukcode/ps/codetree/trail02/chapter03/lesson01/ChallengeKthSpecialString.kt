package org.dukcode.ps.codetree.trail02.chapter03.lesson01.challengeKthSpecialString

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-kth-special-string/description">LINK</a>
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val prefix = st.nextToken()

    val words = List(n) { br.readLine() }

    val kthWord = words.filter { it.startsWith(prefix) }.sorted()[k - 1]

    bw.write(kthWord)

    bw.flush()
}
