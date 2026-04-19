package org.dukcode.ps.codetree.trail02.chapter03.lesson02.intro007

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-007/description">LINK</a>
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val code = st.nextToken()
    val point = st.nextToken()
    val time = st.nextToken().toInt()

    val spy = Spy(code, point, time)

    bw.write(spy.toString())

    bw.flush()
}

class Spy(
    private val code: String,
    private val point: String,
    private val time: Int,
) {
    override fun toString() =
        """
        |secret code : $code
        |meeting point : $point
        |time : $time
        """.trimMargin()
}
