package org.dukcode.ps.codetree.trail02.chapter03.lesson02.challengeProductCode

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-product-code/description">LINK</a>
 */
fun main() {
    val product1 = Product("codetree", 50)

    val st = StringTokenizer(br.readLine())
    val name = st.nextToken()
    val code = st.nextToken().toInt()

    val product2 = Product(name, code)

    bw.write(product1.toString())
    bw.newLine()
    bw.write(product2.toString())
    bw.newLine()

    bw.flush()
}

private class Product(
    private val name: String,
    private val code: Int,
) {
    override fun toString() = "product $code is $name"
}
