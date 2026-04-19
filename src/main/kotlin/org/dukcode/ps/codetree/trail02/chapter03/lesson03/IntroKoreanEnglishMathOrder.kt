package org.dukcode.ps.codetree.trail02.chapter03.lesson03.introKoreanEnglishMathOrder

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-korean-english-math-order/description">LINK</a>
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
        }.sortedWith(
            compareByDescending(Student::korean)
                .thenByDescending(Student::english)
                .thenByDescending(Student::math),
        )

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
    override fun toString(): String = "$name $korean $english $math"
}
