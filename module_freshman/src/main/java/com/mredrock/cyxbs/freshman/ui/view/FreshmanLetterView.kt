package com.mredrock.cyxbs.freshman.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.PixelUtil

class FreshmanLetterView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val framePaint = Paint()
    private val backgroundPaint = Paint()
    private val frameBacgroundPaint = Paint()

    val bitLeftTop by lazy {   BitmapFactory.decodeResource(context.resources, R.mipmap.ic_top_left)}
    val bitRightTop by lazy { BitmapFactory.decodeResource(context.resources, R.mipmap.ic_top_right)}
    val bitLeftBottom by lazy { BitmapFactory.decodeResource(context.resources, R.mipmap.ic_bottom_left)}
    val bitRightBottom by lazy { BitmapFactory.decodeResource(context.resources, R.mipmap.ic_bottom_right)}


    init {
        framePaint.color = Color.rgb(13,0,255)
        backgroundPaint.color = Color.argb(90,255,255,255)
        frameBacgroundPaint.color = Color.rgb(207,205,255)

        framePaint.strokeWidth = PixelUtil.dp2px(context,1f).toFloat()

        framePaint.style = Paint.Style.STROKE
        backgroundPaint.style = Paint.Style.FILL
        frameBacgroundPaint.style = Paint.Style.FILL
    }

    private var viewHeight :Int? = null
    private var viewWidth :Int? = null
    private var targetHeight :Int? = null
    private var targetWidth :Int? = null
    private var height :Int? = null
    private var width :Int? = null

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)

        setMeasuredDimension(viewWidth!!,viewHeight!!)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {

    }
}