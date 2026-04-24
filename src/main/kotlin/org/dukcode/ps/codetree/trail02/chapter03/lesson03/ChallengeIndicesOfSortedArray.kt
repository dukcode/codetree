package org.dukcode.ps.codetree.trail02.chapter03.lesson03.challengeIndicesOfSortedArray

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-indices-of-sorted-array/description">LINK</a>
 */
fun main() {
    val n = br.readLine().trim().toInt()

    val st = StringTokenizer(br.readLine())
    val sortedNums =
        List(n) { Num(it, st.nextToken().toInt()) }
            .sortedWith(compareBy(Num::value, Num::idx))

    val answer =
        IntArray(n).apply {
            sortedNums.forEachIndexed { sortedIdx, num ->
                this[num.idx] = sortedIdx + 1
            }
        }

    bw.write(answer.joinToString(" "))

    bw.flush()
}

class Num(
    val idx: Int,
    val value: Int,
)
