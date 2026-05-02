package org.dukcode.ps.codetree.trail02.chapter05.lesson02.challengeCorrelationBetweenShakingHandsAndInfectiousDiseases2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-correlation-between-shaking-hands-and-infectious-diseases2/description">LINK</a>
 */
fun main() {
    val (n, k, p, t) = parseInts()

    val developers =
        Array(n) {
            if (it == p - 1) {
                Developer(true, k)
            } else {
                Developer(false)
            }
        }

    val handshakes =
        List(t) {
            val (time, x, y) = parseInts()
            Handshake(time, x - 1, y - 1)
        }.sortedBy(Handshake::time)

    for ((_, x, y) in handshakes) {
        when {
            (developers[x].infected && developers[y].infected) -> {
                developers[x].count -= 1
                developers[y].count -= 1
            }

            (developers[y].canInfect()) -> {
                developers[y].infect(developers[x], k)
            }

            (developers[x].canInfect()) -> {
                developers[x].infect(developers[y], k)
            }
        }
    }

    bw.write(developers.joinToString("") { if (it.infected) "1" else "0" })

    bw.flush()
}

private data class Handshake(
    val time: Int,
    val x: Int,
    val y: Int,
)

private data class Developer(
    var infected: Boolean,
    var count: Int = 0,
) {
    fun canInfect() = infected && count > 0

    fun infect(
        other: Developer,
        defaultCnt: Int,
    ) {
        this.count -= 1
        other.infected = true
        other.count = defaultCnt
    }
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
