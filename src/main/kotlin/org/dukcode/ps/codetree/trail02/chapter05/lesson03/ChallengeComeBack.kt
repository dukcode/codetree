package org.dukcode.ps.codetree.trail02.chapter05.lesson03.challengeComeBack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dy = intArrayOf(-1, 0, 0, 1)
private val dx = intArrayOf(0, 1, -1, 0)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-come-back/description">LINK</a>
 */
fun main() {
    bw.write(solve().toString())
    bw.flush()
}

private fun solve(): Int {
    var y = 0
    var x = 0
    var t = 0
    val n = br.readLine().toInt()
    repeat(n) {
        val st = StringTokenizer(br.readLine())

        val dir =
            when (st.nextToken()) {
                "N" -> 0
                "E" -> 1
                "W" -> 2
                "S" -> 3
                else -> throw IllegalStateException()
            }
        val dist = st.nextToken().toInt()

        repeat(dist) {
            y += dy[dir]
            x += dx[dir]
            t++

            if (y == 0 && x == 0) {
                return t
            }
        }
    }
    return -1
}
