package org.dukcode.ps.codetree.trail02.chapter03.lesson03.introLineUpStudents

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-line-up-students/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val students =
        List(n) {
            val number = it + 1

            val st = StringTokenizer(br.readLine())
            val height = st.nextToken().toInt()
            val weight = st.nextToken().toInt()

            Student(number, height, weight)
        }.sortedWith(
            compareByDescending(Student::height)
                .thenByDescending(Student::weight)
                .thenBy(Student::number),
        )

    students.forEach {
        bw.write(it.toString())
        bw.newLine()
    }

    bw.flush()
}

private class Student(
    val number: Int,
    val height: Int,
    val weight: Int,
) {
    override fun toString(): String = "$height $weight $number"
}
