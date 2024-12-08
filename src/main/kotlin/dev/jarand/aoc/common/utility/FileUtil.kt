package dev.jarand.aoc.common.utility

object FileUtil {

    fun lines(file: String): List<String> {
        val stream = {}::class.java.getResourceAsStream(file)
        if (stream == null) {
            throw RuntimeException("Could not open resource as stream: $file")
        }
        return stream.bufferedReader().readLines()
    }
}
