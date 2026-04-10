package org.dukcode.ps.codetree.trail02.chapter01.lesson02

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-decimal-decisions-using-functions/description">LINK</a>
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    bw.write(sumPrimeBetween(a, b).toString())

    bw.flush()
}

fun sumPrimeBetween(
    frIn: Int,
    toIn: Int,
): Int =
    (frIn..toIn)
        .sumOf {
            if (isPrime(it)) it else 0
        }

fun isPrime(num: Int): Boolean {
    if (num <= 2) {
        return true
    }

    var i = 2
    while (i * i <= num) {
        if (num % i == 0) {
            return false
        }
        i++
    }

    return true
}
