package org.dukcode.ps.codetree.trail02.chapter03.lesson02.challengeBombRemoval

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-bomb-removal/description">LINK</a>
 */
fun main() {
    val st = StringTokenizer(br.readLine())
    val code = st.nextToken()
    val color = st.nextToken()
    val second = st.nextToken().toInt()

    val bomb = Bomb(code, color, second)

    bw.write(bomb.toString())

    bw.flush()
}

private class Bomb(
    private val code: String,
    private val color: String,
    private val second: Int,
) {
    override fun toString(): String =
        """
        |code : $code
        |color : $color
        |second : $second
        """.trimMargin()
}
