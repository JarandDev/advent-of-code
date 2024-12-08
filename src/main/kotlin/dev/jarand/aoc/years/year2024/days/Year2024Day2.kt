package dev.jarand.aoc.years.year2024.days

import dev.jarand.aoc.common.domain.Day
import dev.jarand.aoc.common.utility.FileUtil.lines

class Year2024Day2 : Day {

    override fun part1(): Int {
        return prepareReports().let { reports ->
            reports.count { isSafe(report = it) }
        }
    }

    override fun part2(): Int {
        return prepareReports().let { reports ->
            reports
                .map { report -> report to report.indices.mapIndexed { index, _ -> report.filterIndexed { i, _ -> i != index } } }
                .count { (report, dampenedReports) -> isSafe(report) || dampenedReports.any { isSafe(report = it) } }
        }
    }

    private fun isSafe(report: List<Int>): Boolean {
        val levels = report.windowed(2, 1)
        val diffs = levels.map { level ->
            level.first().toInt() - level.last().toInt()
        }
        return diffs.all { diff -> (diff in 1..3 || diff in -3..-1) } && (diffs.all { it < 0 } || diffs.all { it > 0 })
    }

    private fun prepareReports(): List<List<Int>> {
        return lines("/input/2024/day2/input.txt").map { it.split(" ").map { level -> level.toInt() } }
    }
}
