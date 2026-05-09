package org.dukcode.ps.codetree.trail02.chapter05.lesson03.testAddAllTheNumbersOnThePath

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

// UP, RIGHT, DOWN, LEFT
private val dy = intArrayOf(-1, 0, 1, 0)
private val dx = intArrayOf(0, 1, 0, -1)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-add-all-the-numbers-on-the-path/description">LINK</a>
 */
fun main() {
    val (n, _) = parseInts()
    val commands = br.readLine()
    val board =
        Array(n) {
            parseInts()
        }

    var y = n / 2
    var x = n / 2
    var dir = 0

    var sum = board[y][x]
    for (command in commands) {
        if (command == 'R') {
            dir = (dir + 1) % 4
        } else if (command == 'L') {
            dir = (dir + 3) % 4
        } else {
            val ny = y + dy[dir]
            val nx = x + dx[dir]

            if (ny !in 0 until n || nx !in 0 until n) {
                continue
            }

            y = ny
            x = nx
            sum += board[y][x]
        }
    }

    bw.write(sum.toString())

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
