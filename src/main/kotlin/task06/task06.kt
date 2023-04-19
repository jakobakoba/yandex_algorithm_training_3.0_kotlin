import java.io.File
import java.io.PrintWriter
import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

//private val INPUT = File("src/main/kotlin/task06/input.txt").inputStream()
//private val OUTPUT = File("src/main/kotlin/task06/output.txt").outputStream()
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


private class task06 {
    fun solveTestCase(): Int {
        //TODO: Solve the question

        val list = mutableListOf<Interval>()
        val linesList = bufferedReader.useLines { it.toList() }
        val m = linesList[0].toInt()
        val n = linesList[1].toInt()
        linesList.drop(2).take(n).map { it.split(" ") }.forEach { (start, finish) ->
            val applicant = Interval((start.toInt()), finish.toInt())
            checkingIntersection(applicant, list)
            list.add(applicant)
        }



        return list.size

    }

    private fun checkingIntersection(applicant: Interval, list: MutableList<Interval>) {
        val toDelete = mutableListOf<Interval>()
        for (i in list.size - 1 downTo 0) {
            if (list[i].hasIntersection(applicant)) {
                toDelete.add(list[i])
            }
        }
        if (toDelete.isNotEmpty()) {
            list.removeAll(toDelete)
        }
    }
}

data class Interval(val start: Int, val finish: Int) {
    fun hasIntersection(interval: Interval): Boolean {
        return (interval.start >= start && interval.start <= finish)
                || (interval.finish >= start && interval.finish <= finish)
                || (interval.start <= start && interval.finish >= finish)
    }
}


fun main(args: Array<String>) {

    //TODO: Read in each Test Case

    outputWriter.println(
        task06()
            .solveTestCase()
    )


    outputWriter.flush()
}