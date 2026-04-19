package orgMainMain.codetree.trail02.chapter03.lesson01.challengeDetermineSameWord

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-determine-same-word/description">LINK</a>
 */
fun main() {
    val word1 = br.readLine()
    val word2 = br.readLine()

    bw.write(if (word1.sorted() == word2.sorted()) "Yes" else "No")

    bw.flush()
}

private fun String.sorted(): String = String(toCharArray().apply { sort() })
