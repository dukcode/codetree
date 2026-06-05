package org.dukcode.ps.codetree.trail02.chapter06.lesson02.challengeGOrH2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val MX = 100
private const val G = 1
private const val H = 2

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-G-or-H-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val arr = IntArray(MX + 1)
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val idx = st.nextToken().toInt()
        val alphabet = if (st.nextToken() == "G") G else H

        arr[idx] = alphabet
    }

    var maxSameRange = 0
    for (frIn in 0 until MX) {
        if (arr[frIn] == 0) {
            continue
        }
        for (toIn in (frIn + 1)..MX) {
            if (arr[toIn] == 0) {
                continue
            }

            if (isValidRange(arr, frIn, toIn)) {
                maxSameRange = maxOf(maxSameRange, toIn - frIn)
            }
        }
    }

    bw.write(maxSameRange.toString())

    bw.flush()
}

private fun isValidRange(
    arr: IntArray,
    frIn: Int,
    toIn: Int,
): Boolean {
    var cntG = 0
    var cntH = 0
    for (idx in frIn..toIn) {
        when (arr[idx]) {
            G -> cntG++
            H -> cntH++
        }
    }

    return cntG == cntH || cntH == 0 || cntG == 0
}
