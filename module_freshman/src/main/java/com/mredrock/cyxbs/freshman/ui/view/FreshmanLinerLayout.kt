package com.mredrock.cyxbs.freshman.ui.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.view.ViewGroup
import kotlin.math.max

class FreshmanLinerLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private var viewHeight = 0
    private var viewWidth = 0
    private var targetHeight = 0
    private var targetWidth = 0

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context,attrs)
    }

    override fun generateLayoutParams(p: LayoutParams?): LayoutParams {
        return MarginLayoutParams(p)
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)

        repeat(childCount){
            val view = getChildAt(it)
            measureChild(view,widthMeasureSpec,heightMeasureSpec)
            val lp = view.layoutParams as MarginLayoutParams
            val childWidth = view.measuredWidth+lp.topMargin+lp.bottomMargin
            val childHeight = view.measuredHeight+lp.leftMargin+lp.rightMargin


            viewHeight += childHeight
            viewWidth = max(viewWidth, childWidth)
        }
           if(measureWidthMode == MeasureSpec.EXACTLY){
               setMeasuredDimension(measureWidth,viewHeight)
           }else{
               setMeasuredDimension(viewWidth,viewHeight)
           }

        if(targetHeight == 0){
            targetHeight = viewHeight
        }
        if(targetWidth == 0){
            targetWidth = viewWidth
        }

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var top = 0

        repeat(childCount){
            val child = getChildAt(it)

            val lp = child.layoutParams as MarginLayoutParams
            val childHeight = child.measuredHeight+lp.bottomMargin+lp.topMargin
            val childWidth = child.measuredWidth+lp.rightMargin+lp.leftMargin


            child.layout(0,top,childWidth,childHeight+top)
            top += childHeight
        }
    }
    fun doAnimation(){

        val params = layoutParams
        if(viewHeight == 0){
            val animation = ValueAnimator.ofInt(0,targetHeight)
            animation.duration = 500
            viewHeight = targetHeight
            animation.addUpdateListener {
                params.height = it.animatedValue as Int
                layoutParams = params
//                invalidate()
            }
            animation.start()
        }
        else{
            val animation = ValueAnimator.ofInt(targetHeight,0)
            animation.duration = 500
            viewHeight = 0
            animation.addUpdateListener {
                params.height = it.animatedValue as Int
                layoutParams = params
//                invalidate()
            }
            animation.start()
        }
    }



}