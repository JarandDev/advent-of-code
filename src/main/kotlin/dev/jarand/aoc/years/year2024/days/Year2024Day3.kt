package dev.jarand.aoc.years.year2024.days

import dev.jarand.aoc.common.domain.Day
import dev.jarand.aoc.common.utility.FileUtil.lines

class Year2024Day3 : Day {

    override fun part1(): Int {
        return prepareCorruptedInstructions()
            .let { characters ->
                val instructions = mutableListOf<String>()
                var instruction = ""
                characters.forEach { character ->
                    if (character == 'm') {
                        instruction += character
                        if (instruction.lastOrNull() != ')') {
                            instruction = ""
                        }
                    }
                    instruction += character
                    if (instruction.lastOrNull() == ')') {
                        if (validMultiplyInstruction(instruction)) {
                            instructions.add(instruction)
                        }
                        instruction = ""
                    }
                }
                instructions.sumOf { processMultiplyInstruction(it) }
            }
    }

    override fun part2(): Int {
        return prepareCorruptedInstructions()
            .let { characters ->
                val instructions = mutableListOf<String>()
                var instruction = ""
                characters.forEach { character ->
                    if (character in listOf('m', 'd')) {
                        instruction += character
                        if (instruction.lastOrNull() != ')') {
                            instruction = ""
                        }
                    }
                    instruction += character
                    if (instruction.lastOrNull() == ')') {
                        if (validMultiplyInstruction(instruction) || validEnablingConditional(instruction) || validDisablingConditional(instruction)) {
                            instructions.add(instruction)
                        }
                        instruction = ""
                    }
                }
                var enabled = true
                val enabledInstructions = mutableListOf<String>()
                instructions.forEach {
                    if (validMultiplyInstruction(it) && enabled) {
                        enabledInstructions.add(it)
                    } else if (validEnablingConditional(it)) {
                        enabled = true
                    } else if (validDisablingConditional(it)) {
                        enabled = false
                    }
                }
                enabledInstructions.sumOf { processMultiplyInstruction(it) }
            }
    }

    private fun validMultiplyInstruction(instruction: String): Boolean {
        val result = instruction
            .mapIndexed { index, character ->
                (index == 0 && character == 'm') ||
                (index == 1 && character == 'u') ||
                (index == 2 && character == 'l') ||
                (index == 3 && character == '(') ||
                (index == 4 && character.isDigit()) ||
                (index == 5 && (character.isDigit() || character == ',')) ||
                (index == 6 && (character.isDigit() || character == ',')) ||
                (index == 7 && (character.isDigit() || character == ',')) ||
                (index == 8 && (character.isDigit() || character == ',')) ||
                (index == 9 && (character.isDigit() || character == ',')) ||
                (index == 10 && (character.isDigit())) ||
                (index == instruction.length - 1 && instruction[index] == ')' && instruction.length > 5 && instruction.indexOf(',') != -1)
            }
        return result.all { it }
    }

    private fun validEnablingConditional(instruction: String): Boolean {
        val result = instruction
            .mapIndexed { index, character ->
                (index == 0 && character == 'd') ||
                (index == 1 && character == 'o') ||
                (index == 2 && character == '(') ||
                (index == instruction.length - 1 && instruction[index] == ')' && instruction.length == 4)
            }
        return result.all { it }
    }

    private fun validDisablingConditional(instruction: String): Boolean {
        val result = instruction
            .mapIndexed { index, character ->
                (index == 0 && character == 'd') ||
                (index == 1 && character == 'o') ||
                (index == 2 && character == 'n') ||
                (index == 3 && character == '\'') ||
                (index == 4 && character == 't') ||
                (index == 5 && character == '(') ||
                (index == instruction.length - 1 && instruction[index] == ')' && instruction.length == 7)
            }
        return result.all { it }
    }

    private fun processMultiplyInstruction(instruction: String): Int {
        return parseMultiplyInstruction(instruction).let { (a, b) -> a * b }
    }

    private fun parseMultiplyInstruction(instruction: String): Pair<Int, Int> {
        return instruction.removePrefix("mul(").removeSuffix(")").split(",").let { (a, b) -> a.toInt() to b.toInt() }
    }

    private fun prepareCorruptedInstructions(): String {
        return lines("/input/2024/day3/input.txt").joinToString(separator = "")
    }
}
