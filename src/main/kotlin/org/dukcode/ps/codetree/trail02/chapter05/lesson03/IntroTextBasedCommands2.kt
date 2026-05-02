package org.dukcode.ps.codetree.trail02.chapter05.lesson03.introTextBasedCommands2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

// N, E, S, W
private val dx = listOf(0, 1, 0, -1)
private val dy = listOf(1, 0, -1, 0)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-text-based-commands2/description">LINK</a>
 */
fun main() {
    val commands = br.readLine()

    var x = 0
    var y = 0
    var dir = 0
    for (command in commands) {
        when (command) {
            'L' -> {
                dir = (dir + 3) % 4
            }

            'R' -> {
                dir = (dir + 1) % 4
            }

            'F' -> {
                x += dx[dir]
                y += dy[dir]
            }
        }
    }

    bw.write("$x $y")

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
