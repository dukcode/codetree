package org.dukcode.ps.codetree.trail02.chapter05.lesson03.challengeComeBack2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

// N E S W
private val dy = intArrayOf(-1, 0, 1, 0)
private val dx = intArrayOf(0, -1, 0, 1)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-come-back-2/description">LINK</a>
 */
fun main() {
    val commands = br.readLine()

    var y = 0
    var x = 0
    var dir = 0

    var time = -1
    for ((idx, command) in commands.withIndex()) {
        dir =
            when (command) {
                'L' -> (dir + 3) % 4
                'R' -> (dir + 1) % 4
                else -> dir
            }

        if (command == 'F') {
            y += dy[dir]
            x += dx[dir]
        }

        if (y == 0 && x == 0) {
            time = idx + 1
            break
        }
    }

    bw.write(time.toString())

    bw.flush()
}
