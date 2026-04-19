package org.dukcode.ps.codetree.trail02.chapter03.lesson02.introCodeName

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-code-name/description">LINK</a>
 */
fun main() {
    val codeNames =
        List(5) {
            val st = StringTokenizer(br.readLine())
            val name = st.nextToken()
            val score = st.nextToken().toInt()

            CodeName(name, score)
        }

    require(codeNames.isNotEmpty())
    val minScoreCodeName = requireNotNull(codeNames.minByOrNull { it.score })

    bw.write(minScoreCodeName.toString())

    bw.flush()
}

private class CodeName(
    val code: String,
    val score: Int,
) {
    override fun toString(): String = "$code $score"
}
