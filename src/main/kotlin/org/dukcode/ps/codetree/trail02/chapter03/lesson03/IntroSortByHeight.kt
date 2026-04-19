package org.dukcode.ps.codetree.trail02.chapter03.lesson03.introSortByHeight

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sort-by-height/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val people =
        List(n) {
            val st = StringTokenizer(br.readLine())

            val name = st.nextToken()
            val height = st.nextToken().toInt()
            val weight = st.nextToken().toInt()

            Person(name, height, weight)
        }.sortedBy { it.height }

    people.forEach {
        bw.write(it.toString())
        bw.newLine()
    }

    bw.flush()
}

private class Person(
    val name: String,
    val height: Int,
    val weight: Int,
) {
    override fun toString(): String = "$name $height $weight"
}
