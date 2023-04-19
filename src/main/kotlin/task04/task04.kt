import java.io.File
import java.io.PrintWriter
import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

//private val INPUT = File("src/main/kotlin/task04/input.txt").inputStream()
//private val OUTPUT = File("src/main/kotlin/task04/output.txt").outputStream()
private val INPUT = System.`in`
private val OUTPUT = System.out

private val bufferedReader = INPUT.bufferedReader()
private val outputWriter = PrintWriter(OUTPUT, false)
private fun readLn() = bufferedReader.readLine()!!

private fun readList() = readLn().split(' ')
private var tokenizer = StringTokenizer("")
private fun read(): String {
    while (tokenizer.hasMoreTokens().not()) tokenizer = StringTokenizer(readLn(), " ")
    return tokenizer.nextToken()
}

private fun readInt() = read().toInt()
private fun readLong() = read().toLong()
private fun readDouble() = read().toDouble()

private fun readIntList() = readList().map { it.toInt() }
private fun readLongList() = readList().map { it.toLong() }
private fun readDoubleList() = readList().map { it.toDouble() }

private fun readIntArray(n: Int = 0) =
    if (n == 0) readList().run { IntArray(size) { get(it).toInt() } } else IntArray(n) { readInt() }

private fun readLongArray(n: Int = 0) =
    if (n == 0) readList().run { LongArray(size) { get(it).toLong() } } else LongArray(n) { readLong() }

private fun readDoubleArray(n: Int = 0) =
    if (n == 0) readList().run { DoubleArray(size) { get(it).toDouble() } } else DoubleArray(n) { readDouble() }


private fun Int.modPositive(other: Int): Int = if (this % other < 0) ((this % other) + other) else (this % other)


private class task04 {
    fun solveTestCase(): String {
        //TODO: Solve the question
        var res = "-1"
        val n = readInt()
        val k = readInt()
        val row = readInt()
        val position = readInt()

        val odd = k % 2
        var nextRow = row + k / 2
        var prevRow = row - k / 2
        var nextPosition = position
        var prevPosition = position

        if (odd == 1) {
            if (position + 1 > 2) {
                nextRow++
                nextPosition = 1
            } else
                nextPosition = 2
            if (position - 1 < 1) {
                prevRow--
                prevPosition = 2
            } else
                prevPosition = 1
        }
        val prevValid = prevRow > 0
        val nextValid = (nextRow - 1) * 2 + nextPosition - 1 < n

        if (prevValid && nextValid) {
            val dPrev = row - prevRow
            val dNext = nextRow - row
            if (dPrev < dNext) {
                res = "${prevRow} ${prevPosition}"
            } else {
                res = "$nextRow $nextPosition"
            }
        } else if (!prevValid && nextValid) {
            res = "$nextRow $nextPosition"
        } else if (prevValid) {
            res = "$prevRow $prevPosition"
        }



        return res
    }
}

fun main(args: Array<String>) {

    //TODO: Read in each Test Case

    outputWriter.println(
        task04()
            .solveTestCase()
    )


    outputWriter.flush()
}