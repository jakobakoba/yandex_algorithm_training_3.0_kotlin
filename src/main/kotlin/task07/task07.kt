import java.io.PrintWriter
import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

//private val INPUT = File("input.txt").inputStream()
//private val OUTPUT = File("output.txt").outputStream()
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


private class task07 {
    fun solveTestCase(): String {
        //TODO: Solve the question
        val input = bufferedReader
        val request = readLn()
        val server = readLn()
        val response = readLn()

        val requestInSecond = timeInSecond(request)
        val responseInSecond = timeInSecond(response)
        val delta = if (requestInSecond < responseInSecond) {
            ((responseInSecond - requestInSecond) / 2.0).roundToInt()
        } else {
            ((24 * 60 * 60 - requestInSecond + responseInSecond) / 2.0).roundToInt()
        }
        val res = addSeconds(server, delta)

        return res
    }

    private fun addSeconds(s: String, delta: Int): String {
        if (delta == 0) return s
        val (hours, minutes, seconds) = s.split(":").map { it.toInt() }
        var newSeconds = seconds + delta
        var newMinutes = minutes
        var newHours = hours

        if (newSeconds > 59) {
            newMinutes += newSeconds / 60
            newSeconds %= 60
            if (newMinutes > 59) {
                newHours += newMinutes / 60
                newMinutes %= 60
            }
            if (newHours > 23) {
                newHours %= 24
            }
        }
        return "${leaderZero(newHours)}:${leaderZero(newMinutes)}:${leaderZero(newSeconds)}"

    }

    private fun leaderZero(i: Int): String {
        return if (i < 10) "0$i" else i.toString()

    }

    private fun timeInSecond(s: String): Int {
        val (hours, minutes, seconds) = s.split(":").map { it.toInt() }
        return hours * 60 * 60 + minutes * 60 + seconds
    }
}

fun main(args: Array<String>) {

    //TODO: Read in each Test Case

    outputWriter.println(
        task07()
            .solveTestCase()
    )


    outputWriter.flush()
}