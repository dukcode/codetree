package orgMain.ps.codetree.trail02.chapter03.lesson01.introIncDecSorting

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-inc-dec-sorting/description">LINK</a>
 */
fun main() {
    skipLine()
    val arr = parseInts()

    arr.sort()

    bw.write(arr.joinToString(" "))
    bw.newLine()

    arr.sortDescending()

    bw.write(arr.joinToString(" "))
    bw.newLine()

    bw.flush()
}

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }

private fun skipLine() = br.readLine()
