package orgMain.ps.codetree.trail02.chapter06.lesson01.challengeAwkwardDigits2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-awkward-digits-2/description">LINK</a>
 */
fun main() {
    val binary = br.readLine().toCharArray()

    val idxToFlip =
        binary
            .indexOfFirst { it == '0' }
            .takeIf { it != -1 } ?: binary.lastIndex

    binary[idxToFlip] = if (binary[idxToFlip] == '0') '1' else '0'

    bw.write(String(binary).toInt(2).toString())

    bw.flush()
}
