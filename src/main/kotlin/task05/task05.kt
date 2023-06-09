import java.io.File
import java.io.PrintWriter
import java.util.StringTokenizer
import java.util.TreeSet
import kotlin.math.pow
import kotlin.math.sqrt

//
//private val INPUT = File("src/main/kotlin/task05/input.txt").inputStream()
//private val OUTPUT = File("src/main/kotlin/task05/output.txt").outputStream()
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


private class task05 {
    fun solveTestCase(): Any {
        //TODO: Solve the question
        val n = readInt()
        var sum: Long = 0
        if (n != 0) {
            val abc = IntArray(n)
            val set = sortedSetOf<Int>()
            repeat(n) {
                val line = readInt()
                abc[it] = line
                set.add(line)
            }
            var prevLevel = 0
            for (level in set) {
                val frame = getFrame(abc, level - 1)
                val goods = countGoods(frame)
                if (goods == 0) break
                sum += goods.toLong() * (level - prevLevel)
                prevLevel = level

            }
        }
        return sum.toString()

    }

    private fun countGoods(frame: BooleanArray): Int {
        var count = 0
        for (i in 1 until frame.size) {
            if (frame[i - 1] && frame[i]) count++
        }
        return count
    }

    private fun getFrame(ints: IntArray, level: Int): BooleanArray {
        val frame = BooleanArray(ints.size)
        for (i in ints.indices) {
            frame[i] = ints[i] > level
        }
        return frame
    }

}

fun main(args: Array<String>) {
    //TODO: Read in each Test Case

    outputWriter.println(
        task05()
            .solveTestCase()
    )


    outputWriter.flush()
}