package org.dukcode.ps.codetree.trail02.chapter01.lesson01

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see [LINK](https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-the-greatest-common-divisor/description)
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    bw.write(gcd(n, m).toString())

    bw.flush()
}

private fun gcd(
    n: Int,
    m: Int,
): Int = if (m == 0) n else gcd(m, n % m)
