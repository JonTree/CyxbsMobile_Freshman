package com.mredrock.cyxbs.freshman.ui.view

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.mredrock.cyxbs.common.utils.LogUtils

class AnimationLinearLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private var targetWidth :Int = 0
    private var targetHeight :Int = 0
    private var isOpen = false
    private var viewHeight = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        targetWidth = MeasureSpec.getSize(widthMeasureSpec)
        targetHeight = MeasureSpec.getSize(heightMeasureSpec)

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(targetWidth,viewHeight)
    }



    fun doAnimation(){
        LogUtils.d("MyTag","view")
        if(!isOpen){
            isOpen = true
            val animator = ValueAnimator.ofInt(0,targetHeight)
            animator.duration = 1000
            animator.addUpdateListener {
                viewHeight = it.animatedValue as Int
                invalidate()
            }
        }

        else{
            isOpen = false
            val animator = ValueAnimator.ofInt(targetHeight,0)
            animator.duration = 1000
            animator.addUpdateListener {
                viewHeight = it.animatedValue as Int
                invalidate()
            }
        }
    }
}