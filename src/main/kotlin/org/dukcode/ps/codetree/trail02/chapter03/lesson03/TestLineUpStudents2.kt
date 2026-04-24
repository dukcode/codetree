package org.dukcode.ps.codetree.trail02.chapter03.lesson03.testLineUpStudents2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-line-up-students-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val students =
        List(n) { idx ->
            val (h, w) = parseInts()
            Student(h, w, idx + 1)
        }.sortedWith(compareBy(Student::h).thenByDescending(Student::w))

    students.forEach {
        bw.write("${it.h} ${it.w} ${it.id}")
        bw.newLine()
    }
    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }

private class Student(
    val h: Int,
    val w: Int,
    val id: Int,
)
