package orgMain.ps.codetree.trail02.chapter04.lesson01.introDateToDate

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

val dayOfMonth = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-date-to-date/description">LINK</a>
 */
fun main() {
    val (m1, d1, m2, d2) = parseInts()

    val elapsed = toDays(m2, d2) - toDays(m1, d1) + 1

    bw.write(elapsed.toString())

    bw.flush()
}

private fun toDays(
    m: Int,
    d: Int,
): Int = dayOfMonth.take(m - 1).sum() + d

private fun parseInts() =
    StringTokenizer(br.readLine()).run {
        IntArray(countTokens()) {
            nextToken().toInt()
        }
    }
