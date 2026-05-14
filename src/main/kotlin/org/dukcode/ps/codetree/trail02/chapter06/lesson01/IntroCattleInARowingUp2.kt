package org.dukcode.ps.codetree.trail02.chapter06.lesson01.introCattleInARowingUp2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-cattle-in-a-rowing-up-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val heights = parseInts()

    var cnt = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                if (heights[i] <= heights[j] && heights[j] <= heights[k]) {
                    cnt++
                }
            }
        }
    }

    bw.write(cnt.toString())

    bw.flush()
}

private fun solve(
    heights: IntArray,
    lastIdx: Int,
    cnt: Int,
): Int {
    if (cnt == 3) {
        return 1
    }

    return (lastIdx + 1 until heights.size).sumOf {
        if (lastIdx != -1 && heights[lastIdx] > heights[it]) {
            0
        } else {
            solve(heights, it, cnt + 1)
        }
    }
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
