package com.bsobe.spacer

internal open class Pattern(
    val spaceIndexes: MutableList<Int>
) {
    open fun spaces(text: CharSequence) = spaceIndexes
}