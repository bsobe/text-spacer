package com.bsobe.spacer

internal class SequentialPattern(
    private val size: Int
) : Pattern(mutableListOf()) {

    override fun spaces(text: CharSequence): MutableList<Int> {
        require(size != 0) { "Sequential Pattern size can not be 0" }
        val indexes = spaceIndexes
        var index = 0
        while (text.length > index) {
            index += size
            if (text.length > index) {
                indexes.add(index)
            }
        }
        return indexes
    }

}