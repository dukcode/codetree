package org.dukcode.ps.codetree.trail02.chapter03.lesson02.introNextLevel

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-next-level/description">LINK</a>
 */
fun main() {
    val user1 = User("codetree", 10)

    val st = StringTokenizer(br.readLine())
    val id = st.nextToken()
    val level = st.nextToken().toInt()

    val user2 = User(id, level)

    bw.write(user1.toString())
    bw.newLine()
    bw.write(user2.toString())
    bw.newLine()

    bw.flush()
}

class User(
    private val id: String,
    private val level: Int,
) {
    override fun toString() = "user $id lv $level"
}
