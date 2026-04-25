import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private const val OFFSET = 1_000

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-area-of-rectangle-to-cover-debris/description">LINK</a>
 */
fun main() {
    val board =
        Array(2 * OFFSET + 1) {
            IntArray(2 * OFFSET + 1)
        }

    val r1 = parseRectangle()
    fill(board, r1, 1)

    val r2 = parseRectangle()
    fill(board, r2, 0)

    var minX = Int.MAX_VALUE
    var maxX = Int.MIN_VALUE
    var minY = Int.MAX_VALUE
    var maxY = Int.MIN_VALUE
    for (y in -OFFSET until OFFSET) {
        for (x in -OFFSET until OFFSET) {
            if (board[y + OFFSET][x + OFFSET] == 1) {
                minX = minOf(minX, x)
                maxX = maxOf(maxX, x)
                minY = minOf(minY, y)
                maxY = maxOf(maxY, y)
            }
        }
    }

    val area = if (minX == Int.MAX_VALUE) 0 else (maxX - minX + 1) * (maxY - minY + 1)

    bw.write(area.toString())

    bw.flush()
}

private fun fill(
    board: Array<IntArray>,
    rectangle: Rectangle,
    delta: Int,
) {
    for (y in rectangle.y1 until rectangle.y2) {
        for (x in rectangle.x1 until rectangle.x2) {
            board[y + OFFSET][x + OFFSET] = delta
        }
    }
}

private fun parseRectangle(): Rectangle {
    val arr =
        StringTokenizer(br.readLine()).run {
            IntArray(countTokens()) {
                nextToken().toInt()
            }
        }

    return Rectangle(arr[0], arr[1], arr[2], arr[3])
}

data class Rectangle(
    val x1: Int,
    val y1: Int,
    val x2: Int,
    val y2: Int,
)
