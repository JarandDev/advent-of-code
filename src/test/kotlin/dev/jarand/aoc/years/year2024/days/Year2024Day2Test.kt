package dev.jarand.aoc.years.year2024.days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Year2024Day2Test {

    @Test
    fun `2024 - Day 2 - Part 1`() {
        assertThat(Year2024Day2().part1()).isEqualTo(591)
    }

    @Test
    fun `2024 - Day 2 - Part 2`() {
        assertThat(Year2024Day2().part2()).isEqualTo(621)
    }
}
