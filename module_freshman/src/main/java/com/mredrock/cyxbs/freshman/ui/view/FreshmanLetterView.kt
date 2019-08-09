package com.mredrock.cyxbs.freshman.ui.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class FreshmanLetterView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val viewWidth = MeasureSpec.getSize(widthMeasureSpec)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}