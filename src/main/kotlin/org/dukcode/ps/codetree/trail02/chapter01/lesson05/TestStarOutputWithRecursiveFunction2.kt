package orgMain.ps.codetree.trail02.chapter01.lesson05.testStarOutputWithRecursiveFunction2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-star-output-with-recursive-function-2/description">LINK</a>
 */
fun main() {
    val n = br.readLine().toInt()

    printStars(n)

    bw.flush()
}

private fun printStars(n: Int) {
    if (n == 0) {
        return
    }

    bw.write("* ".repeat(n))
    bw.newLine()

    printStars(n - 1)

    bw.write("* ".repeat(n))
    bw.newLine()
}
