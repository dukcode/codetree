package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-quadratic-operations-function/description">LINK</a>
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val a = st.nextToken().toInt()
    val op = st.nextToken()[0]
    val b = st.nextToken().toInt()

    bw.write(operate(a, op, b))

    bw.flush()
}

private fun operate(
    a: Int,
    op: Char,
    b: Int,
): String {
    if (op !in charArrayOf('+', '-', '*', '/')) {
        return "False"
    }

    val res =
        when (op) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            '/' -> a / b
            else -> error("Invalid Operator")
        }

    return "$a $op $b = $res"
}
