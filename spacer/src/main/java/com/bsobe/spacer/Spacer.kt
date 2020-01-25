package com.bsobe.spacer

import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.widget.TextView

class Spacer private constructor(
    textView: TextView,
    private val pattern: Pattern
) : TextWatcher {

    private val measuredSpace: Int = textView.paint.measureText("x").toInt()
    private var internalStopFormatFlag: Boolean = false

    init {
        textView.addTextChangedListener(this)
        textView.text = textView.text
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

    override fun afterTextChanged(editable: Editable?) {
        if (internalStopFormatFlag || editable.isNullOrEmpty()) {
            return
        }
        internalStopFormatFlag = true
        format(editable, measuredSpace)
        internalStopFormatFlag = false
    }

    private fun format(editable: Editable, paddingPx: Int) {
        val textLength = editable.length
        removeOldSpaces(editable, textLength)
        addSpaces(editable, paddingPx)
    }

    private fun removeOldSpaces(editable: Editable, textLength: Int) {
        val spans: Array<SpaceSpan> =
            editable.getSpans(0, textLength, SpaceSpan::class.java)
        spans.forEach { editable.removeSpan(it) }
    }

    private fun addSpaces(editable: Editable, paddingPx: Int) {
        pattern.spaces(editable).forEachIndexed { _, spaceIndex ->
            if (spaceIndex > editable.length) {
                return
            }
            val end: Int
            val start: Int
            val spaceSpan: SpaceSpan
            if (spaceIndex == 0) {
                end = 0
                start = 1
                spaceSpan = SpaceSpan(space = paddingPx, direction = SpaceDirection.START)
            } else {
                end = spaceIndex
                start = spaceIndex - 1
                spaceSpan = SpaceSpan(paddingPx)
            }
            editable.setSpan(spaceSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    class Builder {

        private lateinit var decodedPattern: Pattern

        fun setPattern(pattern: String) = apply {
            this.decodedPattern = PatternSolver(pattern).solve()
        }

        fun setPatternSequentially(eachIndexOfPiece: Int) = apply {
            this.decodedPattern = SequentialPattern(eachIndexOfPiece)
        }

        fun addSpaceIndexAt(index: Int) = apply {
            if (::decodedPattern.isInitialized.not()) {
                decodedPattern = Pattern(mutableListOf())
            }
            decodedPattern.spaceIndexes.add(index)
        }

        fun attach(textView: TextView): Spacer =
            Spacer(textView = textView, pattern = decodedPattern)
    }

    companion object {
        const val SPACE_DIVIDER = "-s"
    }
}