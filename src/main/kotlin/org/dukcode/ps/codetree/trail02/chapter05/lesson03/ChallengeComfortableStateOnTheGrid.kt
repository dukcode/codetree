package orgMain.ps.codetree.trail02.chapter05.lesson03.challengeComfortableStateOnTheGrid

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dy = intArrayOf(0, 1, 0, -1)
private val dx = intArrayOf(1, 0, -1, 0)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-comfortable-state-on-the-grid/description">LINK</a>
 */
fun main() {
    val (n, m) = parseInts()

    val board = Array(n) { BooleanArray(n) }
    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val r = st.nextToken().toInt() - 1
        val c = st.nextToken().toInt() - 1

        board[r][c] = true

        val satisfy = if (board.isSatisfied(r, c)) 1 else 0

        bw.write(satisfy.toString())
        bw.newLine()
    }

    bw.flush()
}

private fun Array<BooleanArray>.isSatisfied(
    r: Int,
    c: Int,
): Boolean {
    val n = this.size

    val cnt =
        (0 until 4).count {
            val nr = r + dy[it]
            val nc = c + dx[it]

            nr in 0 until n && nc in 0 until n && this[nr][nc]
        }

    return cnt == 3
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
