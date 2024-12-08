package dev.jarand.aoc.years.year2024.days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Year2024Day3Test {

    @Test
    fun `2024 - Day 3 - Part 1`() {
        assertThat(Year2024Day3().part1()).isEqualTo(153469856)
    }

    @Test
    fun `2024 - Day 3 - Part 2`() {
        assertThat(Year2024Day3().part2()).isEqualTo(77055967)
    }
}
