package org.dukcode.ps.codetree.trail02.chapter06.lesson01.challengeARoomInACircle

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-a-room-in-a-circle/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val arr =
        IntArray(n) {
            br.readLine().toInt()
        }

    val minMoveCnt =
        arr.indices.minOf { targetIdx ->
            arr.withIndex().sumOf { (idx, cnt) ->
                minOf((n + idx - targetIdx) % n) * cnt
            }
        }

    bw.write(minMoveCnt.toString())

    bw.flush()
}
