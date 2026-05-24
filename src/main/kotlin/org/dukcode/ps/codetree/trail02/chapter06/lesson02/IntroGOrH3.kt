package org.dukcode.ps.codetree.trail02.chapter06.lesson02.introGOrH3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val MX = 10_000

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-G-or-H-3/description">LINK</a>
 */
fun main() {
    val (n, k) = parseInts()

    val arr = IntArray(MX + 1)

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val pos = st.nextToken().toInt()
        val score = if (st.nextToken() == "G") 1 else 2

        arr[pos] += score
    }

    val ans = (1..MX - k).maxOf { start -> (start..start + k).sumOf { arr[it] } }

    bw.write(ans.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
