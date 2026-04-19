package org.dukcode.ps.codetree.trail02.chapter03.lesson02.challengeWhereLive

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-where-live/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val people =
        List(n) {
            val st = StringTokenizer(br.readLine())
            val name = st.nextToken()
            val addr = st.nextToken()
            val city = st.nextToken()

            Person(name, addr, city)
        }

    bw.write(requireNotNull(people.maxByOrNull { it.name }).toString())

    bw.flush()
}

private class Person(
    val name: String,
    val addr: String,
    val city: String,
) {
    override fun toString(): String =
        """
        name $name
        addr $addr
        city $city
        """.trimIndent()
}
