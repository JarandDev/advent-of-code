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
                            characters.upMAS(x, y),
                            characters.upRightMAS(x, y),
                            characters.rightMAS(x, y),
                            characters.downRightMAS(x, y),
                            characters.downMAS(x, y),
                            characters.downLeftMAS(x, y),
                            characters.leftMAS(x, y),
                            characters.upLeftMAS(x, y)
                        ).count { it }
                    }
                }
            }
            xmas
        }
    }

    override fun part2(): Int {
        return 0
    }

    private fun List<CharArray>.upMAS(x: Int, y: Int): Boolean {
        if (y - 3 < 0) return false
        return this[y - 1][x] == 'M' && this[y - 2][x] == 'A' && this[y - 3][x] == 'S'
    }

    private fun List<CharArray>.upLeftMAS(x: Int, y: Int): Boolean {
        if (y - 3 < 0 || x - 3 < 0) return false
        return this[y - 1][x - 1] == 'M' && this[y - 2][x - 2] == 'A' && this[y - 3][x - 3] == 'S'
    }

    private fun List<CharArray>.upRightMAS(x: Int, y: Int): Boolean {
        if (y - 3 < 0 || x + 3 > this[0].size - 1) return false
        return this[y - 1][x + 1] == 'M' && this[y - 2][x + 2] == 'A' && this[y - 3][x + 3] == 'S'
    }

    private fun List<CharArray>.downMAS(x: Int, y: Int): Boolean {
        if (y + 3 > this.size - 1) return false
        return this[y + 1][x] == 'M' && this[y + 2][x] == 'A' && this[y + 3][x] == 'S'
    }

    private fun List<CharArray>.downLeftMAS(x: Int, y: Int): Boolean {
        if (y + 3 > this.size - 1 || x - 3 < 0) return false
        return this[y + 1][x - 1] == 'M' && this[y + 2][x - 2] == 'A' && this[y + 3][x - 3] == 'S'
    }

    private fun List<CharArray>.downRightMAS(x: Int, y: Int): Boolean {
        if (y + 3 > this.size - 1 || x + 3 > this[0].size - 1) return false
        return this[y + 1][x + 1] == 'M' && this[y + 2][x + 2] == 'A' && this[y + 3][x + 3] == 'S'
    }

    private fun List<CharArray>.leftMAS(x: Int, y: Int): Boolean {
        if (x - 3 < 0) return false
        return this[y][x - 1] == 'M' && this[y][x - 2] == 'A' && this[y][x - 3] == 'S'
    }

    private fun List<CharArray>.rightMAS(x: Int, y: Int): Boolean {
        if (x + 3 > this[0].size - 1) return false
        return this[y][x + 1] == 'M' && this[y][x + 2] == 'A' && this[y][x + 3] == 'S'
    }
}
