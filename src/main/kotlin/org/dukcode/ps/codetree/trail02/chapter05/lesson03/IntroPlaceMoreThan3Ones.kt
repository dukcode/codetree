package org.dukcode.ps.codetree.trail02.chapter05.lesson03.introPlaceMoreThan3Ones

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-place-more-than-3-ones/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val board =
        Array(n) {
            val st = StringTokenizer(br.readLine())
            IntArray(n) {
                st.nextToken().toInt()
            }
        }

    var cnt = 0
    for (y in 0 until n) {
        for (x in 0 until n) {
            val adjacentOnes =
                (0 until 4).count { dir ->
                    val ny = y + dy[dir]
                    val nx = x + dx[dir]

                    inRange(ny, nx, n) && board[ny][nx] == 1
                }

            if (adjacentOnes >= 3) {
                cnt++
            }
        }
    }

    bw.write(cnt.toString())

    bw.flush()
}

private fun inRange(
    y: Int,
    x: Int,
    n: Int,
): Boolean = y in 0 until n && x in 0 until n
