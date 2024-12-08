package dev.jarand.aoc.years.year2024.days

import dev.jarand.aoc.common.domain.Day
import dev.jarand.aoc.common.utility.FileUtil

class Year2024Day5 : Day {

    override fun part1(): Int {
        return prepareData().let { (rules, updates) ->
            updates
                .asSequence()
                .map { update -> update.windowed(2, 1).map { update to rules.contains(listOf(it[0], it[1])) } }
                .filter { update -> update.all { it.second } }
                .map { it.first().first }
                .map { validUpdate -> validUpdate[validUpdate.size / 2] }
                .sumOf { middlePageNumber -> middlePageNumber }
        }
    }

    override fun part2(): Int {
        return 0
    }

    private fun prepareData(): Pair<List<List<Int>>, List<List<Int>>> {
        return FileUtil.lines("/input/2024/day5/input.txt")
            .let {
                val empty = it.indexOf("")
                it.subList(0, empty) to it.subList(empty + 1, it.size)
            }
            .let { (rules, updates) ->
                rules.map { rule -> rule.split("|").map { it.toInt() } } to updates.map { update -> update.split(",").map { it.toInt() } }
            }
    }
}
