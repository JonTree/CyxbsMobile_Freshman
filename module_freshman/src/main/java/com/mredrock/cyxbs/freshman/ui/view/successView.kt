package com.mredrock.cyxbs.freshman.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.freshman.util.PixelUtil

class successView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var viewWidth :Int? = null
    private var viewHeight :Int? = null
    private var degree :Float? =null

    private val rectF = RectF(0f,0f,viewWidth!!.toFloat(),viewHeight!!.toFloat())
    private val paint = Paint()
    init {
        paint.color = Color.rgb(111,140,255)
        paint.strokeWidth = PixelUtil.dp2px(context,5f).toFloat()
        paint.style = Paint.Style.STROKE

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        viewWidth = if(MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY){
            MeasureSpec.getSize(widthMeasureSpec)
        } else{
            PixelUtil.dp2px(context,26.5f)
        }
        viewHeight = if(MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY){
            MeasureSpec.getSize(widthMeasureSpec)
        }else{
            PixelUtil.dp2px(context,26.5f)
        }

        setMeasuredDimension(viewWidth!!,viewHeight!!)
    }

    override fun onDraw(canvas: Canvas?) {
        drawCircle(canvas)

    }
    private fun drawCircle(canvas: Canvas?){
        canvas?.save()

        canvas?.rotate(180f)
        if(degree != null){

            canvas?.drawArc(rectF,0f,degree!!,false,paint)
        }

        canvas?.restore()
    }

    private fun drawHook(canvas: Canvas?){

    }
}