package dev.jarand.aoc

import dev.jarand.aoc.years.year2024.days.Year2024Day1
import dev.jarand.aoc.years.year2024.days.Year2024Day2
import dev.jarand.aoc.years.year2024.days.Year2024Day3
import dev.jarand.aoc.years.year2024.days.Year2024Day4

fun main() {
    println("Advent of Code")
    println("Day 1")
    println("Total distance: ${Year2024Day1().part1()}")
    println("Similarity score: ${Year2024Day1().part2()}")

    println("Day 2")
    println("Safe reports: ${Year2024Day2().part1()}")
    println("Safe reports with problem dampening: ${Year2024Day2().part2()}")

    println("Day 3")
    println("Sum: ${Year2024Day3().part1()}")
    println("Sum with conditions: ${Year2024Day3().part2()}")

    println("Day 4")
    println("XMAS appearance: ${Year2024Day4().part1()}")
    println("XMAS appearance: ${Year2024Day4().part2()}")
}
