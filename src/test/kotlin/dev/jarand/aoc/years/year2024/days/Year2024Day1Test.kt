package dev.jarand.aoc.years.year2024.days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Year2024Day1Test {

    @Test
    fun `2024 - Day 1 - Part 1`() {
        assertThat(Year2024Day1().part1()).isEqualTo(2756096)
    }

    @Test
    fun `2024 - Day 1 - Part 2`() {
        assertThat(Year2024Day1().part2()).isEqualTo(23117829)
    }
}
