package dev.jarand.aoc.years.year2024.days

import dev.jarand.aoc.common.domain.Day
import dev.jarand.aoc.common.utility.FileUtil

class Year2024Day4 : Day {

    override fun part1(): Int {
        return FileUtil.lines("/input/2024/day4/input.txt").let { lines ->
            var xmas = 0
            val characters = lines.map { it.toCharArray() }
            for (y in characters.indices) {
                for (x in characters[y].indices) {
                    val character = characters[y][x]
                    if (character == 'X') {
                        xmas += listOf(
                            characters.up(x, y, "XMAS"),
                            characters.upRight(x, y, "XMAS"),
                            characters.right(x, y, "XMAS"),
                            characters.downRight(x, y, "XMAS"),
                            characters.down(x, y, "XMAS"),
                            characters.downLeft(x, y, "XMAS"),
                            characters.left(x, y, "XMAS"),
                            characters.upLeft(x, y, "XMAS")
                        ).count { result -> result.all { it.first } }
                    }
                }
            }
            xmas
        }
    }

    override fun part2(): Int {
        return FileUtil.lines("/input/2024/day4/input.txt").let { lines ->
            val matchedWords = mutableListOf<List<Pair<Boolean, Pair<Int, Int>>>>()
            val characters = lines.map { it.toCharArray() }
            for (y in characters.indices) {
                for (x in characters[y].indices) {
                    matchedWords.addAll(
                        listOf(
                            characters.upRight(x, y, "MAS"),
                            characters.upLeft(x, y, "MAS"),
                            characters.downRight(x, y, "MAS"),
                            characters.downLeft(x, y, "MAS")
                        ).filter { result -> result.all { it.first } }
                    )
                }
            }
            matchedWords.groupBy { it[1].second }.filter { it.value.size == 2 }.count()
        }
    }

    private fun List<CharArray>.up(x: Int, y: Int, word: String): List<Pair<Boolean, Pair<Int, Int>>> {
        if (y - (word.length - 1) < 0) return listOf(false to (0 to 0))
        return word.mapIndexed { index, character ->
            (this[y - index][x] == character) to (y - index to x)
        }
    }

    private fun List<CharArray>.upLeft(x: Int, y: Int, word: String): List<Pair<Boolean, Pair<Int, Int>>> {
        if (y - (word.length - 1) < 0 || x - (word.length - 1) < 0) return listOf(false to (0 to 0))
        return word.mapIndexed { index, character ->
            (this[y - index][x - index] == character) to (y - index to x - index)
        }
    }

    private fun List<CharArray>.upRight(x: Int, y: Int, word: String): List<Pair<Boolean, Pair<Int, Int>>> {
        if (y - (word.length - 1) < 0 || x + (word.length - 1) > this[0].size - 1) return listOf(false to (0 to 0))
        return word.mapIndexed { index, character ->
            (this[y - index][x + index] == character) to (y - index to x + index)
        }
    }

    private fun List<CharArray>.down(x: Int, y: Int, word: String): List<Pair<Boolean, Pair<Int, Int>>> {
        if (y + (word.length - 1) > this.size - 1) return listOf(false to (0 to 0))
        return word.mapIndexed { index, character ->
            (this[y + index][x] == character) to (y + index to x)
        }
    }

    private fun List<CharArray>.downLeft(x: Int, y: Int, word: String): List<Pair<Boolean, Pair<Int, Int>>> {
        if (y + (word.length - 1) > this.size - 1 || x - (word.length - 1) < 0) return listOf(false to (0 to 0))
        return word.mapIndexed { index, character ->
            (this[y + index][x - index] == character) to (y + index to x - index)
        }
    }

    private fun List<CharArray>.downRight(x: Int, y: Int, word: String): List<Pair<Boolean, Pair<Int, Int>>> {
        if (y + (word.length - 1) > this.size - 1 || x + (word.length - 1) > this[0].size - 1) return listOf(false to (0 to 0))
        return word.mapIndexed { index, character ->
            (this[y + index][x + index] == character) to (y + index to x + index)
        }
    }

    private fun List<CharArray>.left(x: Int, y: Int, word: String): List<Pair<Boolean, Pair<Int, Int>>> {
        if (x - (word.length - 1) < 0) return listOf(false to (0 to 0))
        return word.mapIndexed { index, character ->
            (this[y][x - index] == character) to (y to x - index)
        }
    }

    private fun List<CharArray>.right(x: Int, y: Int, word: String): List<Pair<Boolean, Pair<Int, Int>>> {
        if (x + (word.length - 1) > this[0].size - 1) return listOf(false to (0 to 0))
        return word.mapIndexed { index, character ->
            (this[y][x + index] == character) to (y to x + index)
        }
    }
}
