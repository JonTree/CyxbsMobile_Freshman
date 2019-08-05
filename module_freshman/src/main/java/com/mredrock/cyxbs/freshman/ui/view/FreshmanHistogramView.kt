package com.mredrock.cyxbs.freshman.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.PixelUtil

class FreshmanHistogramView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val coordinatePaint = Paint()
    private val framePaint = Paint()
    private val blueFillingPaint =Paint()
    private val pinkFillingPaint = Paint()
    private val lightBluePaint = Paint()

    val viewWidth = PixelUtil.dp2px(context,282.toFloat())
    val coordinateWidth =PixelUtil.dp2px(context,258.toFloat())
    val viewHeight = PixelUtil.dp2px(context,194.toFloat())
    val coordinateHeigh = PixelUtil.dp2px(context,175.toFloat())
    val arrowConst = PixelUtil.dp2px(context,5.toFloat())
    init {
        setLayerType(LAYER_TYPE_SOFTWARE,null)
        coordinatePaint.color = 0x5c7ffc
        framePaint.color = 0x809bff
        blueFillingPaint.color = 0x698aff
        pinkFillingPaint.color = 0x516eff
        lightBluePaint.color = 0x3cceff

        var width = PixelUtil.dp2px(context, 1.toFloat())
        coordinatePaint.strokeWidth = width.toFloat()
        framePaint.strokeWidth = width.toFloat()

        coordinatePaint.style = Paint.Style.FILL_AND_STROKE
        framePaint.style = Paint.Style.STROKE
        blueFillingPaint.style = Paint.Style.FILL
        pinkFillingPaint.style = Paint.Style.FILL
        lightBluePaint.style = Paint.Style.FILL
    }
    private var firstData:Int
    private var secondData:Int
    private var thirdData:Int
    private var firstTitle:String?
    private var secondTitle:String?
    private var thirdTitle:String?
    init {
        val typedArray:TypedArray = context.obtainStyledAttributes(attrs, R.styleable.FreshmanHistogramView)
        firstData = typedArray.getInt(R.styleable.FreshmanHistogramView_firstData,-1)
        secondData = typedArray.getInt(R.styleable.FreshmanHistogramView_secondData,-1)
        thirdData = typedArray.getInt(R.styleable.FreshmanHistogramView_thirdData,-1)

        firstTitle = typedArray.getString(R.styleable.FreshmanHistogramView_firstTitle)
        secondTitle = typedArray.getString(R.styleable.FreshmanHistogramView_secondTitle)
        thirdTitle = typedArray.getString(R.styleable.FreshmanHistogramView_thirdTitle)
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getMode(widthMeasureSpec),MeasureSpec.getSize(viewWidth)),
//            MeasureSpec.makeMeasureSpec(MeasureSpec.getMode(heightMeasureSpec),MeasureSpec.getSize(viewHeight)))
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        LogUtils.d("MyTag","w="+w+"h="+h)
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.save()
//        canvas?.translate(viewWidth.toFloat(),viewHeight.toFloat())

        canvas?.drawText("aaaaaaa",0.toFloat(),100.toFloat(),coordinatePaint)
        drawHorizontal(canvas)
        drawVertical(canvas)
        drawRect(0,firstData,firstTitle,canvas,blueFillingPaint)
        drawRect(1,secondData,secondTitle,canvas,pinkFillingPaint)
        drawRect(2,thirdData,secondTitle,canvas,lightBluePaint)

    }
    private fun drawHorizontal(canvas: Canvas?){
        canvas?.drawLine(0.toFloat(),0.toFloat(),coordinateWidth.toFloat(),0.toFloat(),coordinatePaint)
        canvas?.drawLine(coordinateWidth.toFloat()-PixelUtil.dp2px(context,4.toFloat()),
            PixelUtil.dp2px(context,3.toFloat()).toFloat(),coordinateWidth.toFloat(),0.toFloat(),coordinatePaint)
        canvas?.drawLine(coordinateWidth.toFloat()-PixelUtil.dp2px(context,4.toFloat()),
            -PixelUtil.dp2px(context,3.toFloat()).toFloat(),coordinateWidth.toFloat(),0.toFloat(),coordinatePaint)

    }
    private fun drawVertical(canvas: Canvas?){
        canvas?.drawLine(0.toFloat(),0.toFloat(),0.toFloat(),coordinateHeigh.toFloat(),coordinatePaint)
        canvas?.drawLine(0.toFloat(),coordinateHeigh.toFloat(),PixelUtil.dp2px(context,3.toFloat()).toFloat(),
            coordinateHeigh.toFloat()-PixelUtil.dp2px(context,4.toFloat()).toFloat(),coordinatePaint)
        canvas?.drawLine(0.toFloat(),coordinateHeigh.toFloat(),-PixelUtil.dp2px(context,3.toFloat()).toFloat(),
            coordinateHeigh.toFloat()-PixelUtil.dp2px(context,4.toFloat()).toFloat(),coordinatePaint)
    }
    private fun drawRect(index:Int,data:Int,title:String?,canvas: Canvas?,insidePaint:Paint){
        var i =index*2+1
        var rect:Rect = Rect(PixelUtil.dp2px(context ,(i*35).toFloat()),data/100*(PixelUtil.dp2px(context,coordinateHeigh.toFloat())),
            PixelUtil.dp2px(context ,((i+1)*35).toFloat()),PixelUtil.dp2px(context ,1.toFloat()))

        canvas?.drawRect(rect,framePaint)
        canvas?.drawRect(rect,insidePaint)

        coordinatePaint.textAlign = Paint.Align.CENTER
        if(title!= null)
            canvas?.drawText(title,PixelUtil.dp2px(context ,((i+0.5)*35).toFloat()).toFloat(),-PixelUtil.dp2px(context ,(16).toFloat()).toFloat(),coordinatePaint)
    }
}