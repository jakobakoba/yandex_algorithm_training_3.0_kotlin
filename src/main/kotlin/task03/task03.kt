import java.io.*
import java.lang.StringBuilder
import java.util.StringTokenizer
import java.util.TreeSet
import kotlin.math.pow
import kotlin.math.sqrt

//private val INPUT = File("src/main/kotlin/task03/input.txt").inputStream()
//private val OUTPUT = File("src/main/kotlin/task03/output.txt").outputStream()
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


private class task03 {
    fun solveTestCase(): Any {
        //TODO: Solve the question


        val reader = bufferedReader
        val sb = StringBuilder()
        val n = readInt()
        val diegoCardSource = readLn()
        val k = readInt()
        val collectorsSource = readLn()

        if (n == 0) {
            for (i in 0 until k) {
                sb.append(0)
                sb.append("\n")
            }
            return sb.toString()
        }

        if (k == 0) return sb

        val diegoCardSet = TreeSet<Int>(diegoCardSource.split(" ").map { it.toInt() })
        val diegoCards = diegoCardSet.toIntArray()

        val requirement = collectorsSource.split(" ").map { it.toInt() }.toIntArray()

        for (max in requirement) {
            var left = 0
            var right = diegoCards.size - 1
            while (left <= right) {
                val mid = (left + right) / 2
                if (diegoCards[mid] >= max) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            sb.append(left)
            sb.append("\n")
        }
        return sb.toString()
    }

}


fun main(args: Array<String>) {

    //TODO: Read in each Test Case

    outputWriter.println(
        task03()
            .solveTestCase()
    )

    outputWriter.flush()
}