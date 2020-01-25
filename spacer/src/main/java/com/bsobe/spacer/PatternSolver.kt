package com.bsobe.spacer

import com.bsobe.spacer.Spacer.Companion.SPACE_DIVIDER as SPACE

internal class PatternSolver(private val encodedPattern: String) {

    fun solve(): Pattern {
        val spacePatternLength: Int = SPACE.length

        val spaceIndexList: MutableList<Int> = mutableListOf()
        if (encodedPattern.contains(SPACE)) {
            val builder = StringBuilder(encodedPattern)
            var oldIndex = 0

            while (builder.contains(SPACE)) {
                val patternIndex = builder.indexOf(SPACE)
                val index = patternIndex + oldIndex
                oldIndex += patternIndex
                spaceIndexList.add(index)
                builder.delete(0, patternIndex + spacePatternLength)
            }
        }
        return Pattern(spaceIndexList)
    }

}