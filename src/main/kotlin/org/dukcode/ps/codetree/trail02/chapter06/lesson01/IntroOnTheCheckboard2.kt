package org.dukcode.ps.codetree.trail02.chapter06.lesson01.introOnTheCheckboard2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-on-the-checkboard-2/description">LINK</a>
 */
fun main() {
    val (h, w) = parseInts()
    val board =
        Array(h) {
            val st = StringTokenizer(br.readLine())
            CharArray(w) {
                st.nextToken().first()
            }
        }

    bw.write(countRoute(board, h, w, 0, 0, 1).toString())

    bw.flush()
}

private fun countRoute(
    board: Array<CharArray>,
    h: Int,
    w: Int,
    y: Int,
    x: Int,
    count: Int,
): Int {
    if (count == 4) {
        if (y == h - 1 && x == w - 1) {
            return 1
        }

        return 0
    }

    var ret = 0
    for (ny in (y + 1) until h) {
        for (nx in (x + 1) until w) {
            if (board[y][x] == board[ny][nx]) {
                continue
            }

            ret += countRoute(board, h, w, ny, nx, count + 1)
        }
    }

    return ret
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
