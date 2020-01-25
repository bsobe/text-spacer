package com.bsobe.spacer

import android.graphics.Canvas
import android.graphics.Paint
import android.text.style.ReplacementSpan

internal class SpaceSpan(
    private val space: Int,
    private val direction: SpaceDirection = SpaceDirection.END
) : ReplacementSpan() {

    override fun getSize(
        paint: Paint,
        text: CharSequence?,
        start: Int,
        end: Int,
        fm: Paint.FontMetricsInt?
    ): Int {
        val widths = FloatArray(end - start)
        paint.getTextWidths(text, start, end, widths)
        var sum = space
        widths.forEach { sum += it.toInt() }
        return sum
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence?,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        if (direction == SpaceDirection.START) {
            canvas.drawText(text ?: "", start, end, x + space, y.toFloat(), paint)
        } else {
            canvas.drawText(text ?: "", start, end, x, y.toFloat(), paint)
        }
    }
}