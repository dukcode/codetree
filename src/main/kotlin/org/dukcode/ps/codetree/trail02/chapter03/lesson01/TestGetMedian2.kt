package org.dukcode.ps.codetree.trail02.chapter03.lesson01.testGetMedian2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-get-median-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()
    val arr = parseInts()

    val nums = mutableListOf<Int>()
    for (idx in 0 until n) {
        nums.add(arr[idx])

        if (idx % 2 == 0) {
            nums.sort()
            bw.write(nums[nums.size / 2].toString())
            bw.write(" ")
        }
    }

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
