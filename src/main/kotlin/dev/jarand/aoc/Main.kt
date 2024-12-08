package dev.jarand.aoc

import dev.jarand.aoc.years.year2024.days.Year2024Day1
import dev.jarand.aoc.years.year2024.days.Year2024Day2

fun main() {
    println("Advent of Code")
    println("Day 1")
    println("Total distance: ${Year2024Day1().part1()}")
    println("Similarity score: ${Year2024Day1().part2()}")

    println("Day 2")
    println("Safe reports: ${Year2024Day2().part1()}")
    println("Safe reports with problem dampening: ${Year2024Day2().part2()}")
}
