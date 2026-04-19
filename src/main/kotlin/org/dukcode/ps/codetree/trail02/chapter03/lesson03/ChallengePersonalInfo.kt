package org.dukcode.ps.codetree.trail02.chapter03.lesson03.challengePersonalInfo

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-personal-info/description">LINK</a>
 */
fun main() {
    val people =
        MutableList(5) {
            val st = StringTokenizer(br.readLine())

            val name = st.nextToken()
            val height = st.nextToken().toInt()
            val weight = st.nextToken().toDouble()

            Person(name, height, weight)
        }

    people.sortBy(Person::name)

    bw.write("name")
    bw.newLine()
    people.forEach {
        bw.write(it.toString())
        bw.newLine()
    }

    bw.newLine()

    people.sortByDescending(Person::height)

    bw.write("height")
    bw.newLine()
    people.forEach {
        bw.write(it.toString())
        bw.newLine()
    }

    bw.flush()
}

private class Person(
    val name: String,
    val height: Int,
    val weight: Double,
) {
    override fun toString(): String = "$name $height $weight"
}
