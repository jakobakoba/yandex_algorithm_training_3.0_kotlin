import java.io.File
import java.io.PrintWriter
import java.lang.StringBuilder
import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

//private val INPUT = File("src/main/kotlin/task01/input.txt").inputStream()
//private val OUTPUT = File("src/main/kotlin/task01/output.txt").outputStream()
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


private class task01 {
    fun solveTestCase(): String {
        val input = bufferedReader
        var max = 0
        val map = mutableMapOf<Char, Int>()
        val sb = StringBuilder()

        input.forEachLine { line ->
            line.forEach { c ->
                if (c != ' ') {
                    map[c] = (map[c] ?: 0) + 1
                    val count = map[c]!!
                    if (count > max) max = count
                }

            }
        }
        repeat(max) { i ->
            map.keys.sorted().forEach() { c ->
                if (map[c]!! > max - i - 1) sb.append('#')
                else sb.append(' ')
            }
            sb.append('\n')
        }
        map.keys.sorted().forEach { c -> sb.append(c) }

        return sb.toString()

    }


}

fun main(args: Array<String>) {

    //TODO: Read in each Test Case

    outputWriter.println(
        task01()
            .solveTestCase()
    )


    outputWriter.flush()
}