package dev.jarand.aoc.years.year2024.days

import dev.jarand.aoc.common.domain.Day
import dev.jarand.aoc.common.utility.FileUtil

class Year2024Day1 : Day {

    override fun part1(): Int {
        return sortLists().let { (groupA, groupB) ->
            groupA.mapIndexed { index, locationID ->
                val distance = locationID - groupB[index]
                if (distance < 0) {
                    distance * -1
                } else {
                    distance
                }
            }.sum()
        }
    }

    override fun part2(): Int {
        return sortLists().let { (groupA, groupB) ->
            groupA.sumOf { locationID ->
                locationID * groupB.count { it == locationID }
            }
        }
    }

    private fun sortLists(): Pair<List<Int>, List<Int>> {
        return FileUtil.lines("/input/2024/day1/input.txt").map {
            val locationIDs = it.split("   ")
            locationIDs[0].toInt() to locationIDs[1].toInt()
        }.let { locationIDs ->
            val groupA = locationIDs.map { it.first }.sorted()
            val groupB = locationIDs.map { it.second }.sorted()
            groupA to groupB
        }
    }
}
