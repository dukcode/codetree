package org.dukcode.ps.codetree.trail02.chapter03.lesson03.introCompareTotalPoints

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-compare-total-points/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val students =
        List(n) {
            val st = StringTokenizer(br.readLine())

            val name = st.nextToken()
            val korean = st.nextToken().toInt()
            val english = st.nextToken().toInt()
            val math = st.nextToken().toInt()

            Student(name, korean, english, math)
        }.sortedBy(Student::totalScore)

    students.forEach {
        bw.write(it.toString())
        bw.newLine()
    }

    bw.flush()
}

private class Student(
    val name: String,
    val korean: Int,
    val english: Int,
    val math: Int,
) {
    val totalScore: Int
        get() = korean + english + math

    override fun toString(): String = "$name $korean $english $math"
}
