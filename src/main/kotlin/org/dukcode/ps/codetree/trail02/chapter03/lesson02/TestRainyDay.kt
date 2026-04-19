package org.dukcode.ps.codetree.trail02.chapter03.lesson02.testRainyDay

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-rainy-day/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    val firstRainyDay =
        checkNotNull(
            List(n) {
                val st = StringTokenizer(br.readLine())

                val date = st.nextToken()
                val dayOfWeek = st.nextToken()
                val weather = st.nextToken()

                Day(date, dayOfWeek, weather)
            }.filter { it.weather == "Rain" }
                .minByOrNull { it.date },
        )

    bw.write(firstRainyDay.toString())

    bw.flush()
}

private class Day(
    val date: String,
    val dayOfWeek: String,
    val weather: String,
) {
    override fun toString(): String = "$date $dayOfWeek $weather"
}
