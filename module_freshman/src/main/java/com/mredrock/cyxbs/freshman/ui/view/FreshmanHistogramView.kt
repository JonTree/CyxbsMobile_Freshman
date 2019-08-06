package com.mredrock.cyxbs.freshman.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.PixelUtil

class FreshmanHistogramView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val coordinatePaint = Paint()
    private val emptyPaint = Paint()
    private val framePaint = Paint()
    private val blueFillingPaint =Paint()
    private val pinkFillingPaint = Paint()
    private val lightBlueFillingPaint = Paint()
    private val dataPaint = Paint()
    private val list :List<Paint> = listOf(blueFillingPaint,pinkFillingPaint,lightBlueFillingPaint)

    private var viewWidth :Float? = null
    private var coordinateWidth :Float? = null

    private var viewHeight :Float? = null
    private var coordinateHeight :Float? = null 
    private val arrowConst = PixelUtil.dp2px(context,5.toFloat())
    private var mergin = 0.08
    private var paintWidth = PixelUtil.dp2px(context, 1.toFloat())
    private var textWidth = PixelUtil.sp2px(context,13.toFloat()).toFloat()
    init {
        setLayerType(LAYER_TYPE_SOFTWARE,null)
        coordinatePaint.color = Color.rgb(124,150,255)
        dataPaint.color = Color.rgb(161,164,165)
        framePaint.color = Color.rgb(104,130,255)
        blueFillingPaint.color = Color.rgb(81,110,255)
        pinkFillingPaint.color = Color.rgb(255,115,184)
        lightBlueFillingPaint.color = Color.rgb(60,206,255)


        coordinatePaint.strokeWidth = paintWidth.toFloat()
        framePaint.strokeWidth = paintWidth.toFloat()

        coordinatePaint.style = Paint.Style.FILL_AND_STROKE
        framePaint.style = Paint.Style.STROKE
        blueFillingPaint.style = Paint.Style.FILL
        pinkFillingPaint.style = Paint.Style.FILL
        lightBlueFillingPaint.style = Paint.Style.FILL

        coordinatePaint.textAlign = Paint.Align.CENTER
        dataPaint.textAlign = Paint.Align.CENTER
        coordinatePaint.textSize = textWidth
        dataPaint.textSize = textWidth
        coordinatePaint.letterSpacing = 0.1.toFloat()
        dataPaint.letterSpacing = 0.07.toFloat()
    }
    var title:List<String>? = null
    var data:List<Float>? = null

    fun bindData(title:List<String>,data:List<Float>){
        this.title = title
        this.data = data
        postInvalidate()
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        viewWidth = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        coordinateWidth = MeasureSpec.getSize(widthMeasureSpec).toFloat()*0.9.toFloat()
        viewHeight = MeasureSpec.getSize(heightMeasureSpec).toFloat()
        coordinateHeight = MeasureSpec.getSize(heightMeasureSpec).toFloat()*0.9.toFloat()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getMode(widthMeasureSpec),MeasureSpec.getSize(viewWidth)),
//            MeasureSpec.makeMeasureSpec(MeasureSpec.getMode(heightMeasureSpec),MeasureSpec.getSize(viewHeight)))

//        setMeasuredDimension(viewWidth,
//           viewHeight)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        LogUtils.d("MyTag","w="+w+"h="+h)
        super.onSizeChanged(w, h, oldw, oldh)
    }
//    var titleMergin = 20.toFloat()
//    fun titleMergin(mergin: Float){
//        titleMergin = mergin
//    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.save()
//        var path :Path = Path()
//        path.moveTo(titleMergin,0.toFloat())
//        path.lineTo(0.toFloat(), (500).toFloat())
//        canvas?.drawPath(path,coordinatePaint)
//        canvas?.drawTextOnPath("挂科率前三",path,0.toFloat(),0.toFloat(),coordinatePaint)

        canvas?.translate(((viewWidth!!-coordinateWidth!!)*0.5).toFloat(),((viewHeight!!-coordinateHeight!!)*0.1+coordinateHeight!!).toFloat())


        drawHorizontal(canvas)
        drawVertical(canvas)
//        if(data != null && title != null){
            repeat(3){
                drawRect(it, data!![it], title!![it],canvas,list[it])

            }
//        }
    }
    private fun drawHorizontal(canvas: Canvas?){
        canvas?.drawLine(0.toFloat(),0.toFloat(),coordinateWidth!!.toFloat(),0.toFloat(),coordinatePaint)
        canvas?.drawLine(coordinateWidth!!.toFloat()-PixelUtil.dp2px(context,4.toFloat()),
            PixelUtil.dp2px(context,3.toFloat()).toFloat(),coordinateWidth!!.toFloat(),0.toFloat(),coordinatePaint)
        canvas?.drawLine(coordinateWidth!!.toFloat()-PixelUtil.dp2px(context,4.toFloat()),
            -PixelUtil.dp2px(context,3.toFloat()).toFloat(),coordinateWidth!!.toFloat(),0.toFloat(),coordinatePaint)

    }
    private fun drawVertical(canvas: Canvas?){
        canvas?.drawLine(0.toFloat(),0.toFloat(),0.toFloat(),-coordinateHeight!!.toFloat(),coordinatePaint)
        canvas?.drawLine(0.toFloat(),-coordinateHeight!!.toFloat(),PixelUtil.dp2px(context,3.toFloat()).toFloat(),
            -coordinateHeight!!.toFloat()+PixelUtil.dp2px(context,4.toFloat()).toFloat(),coordinatePaint)
        canvas?.drawLine(0.toFloat(),-coordinateHeight!!.toFloat(),-PixelUtil.dp2px(context,3.toFloat()).toFloat(),
            -coordinateHeight!!.toFloat()+PixelUtil.dp2px(context,4.toFloat()).toFloat(),coordinatePaint)
    }
    private fun drawRect(index:Int,data:Float,title:String?,canvas: Canvas?,insidePaint:Paint){
        var i =index*2+1


        var pix = (coordinateWidth!!/11.5*(index*3.5+1)).toFloat()


        LogUtils.d("MyTag","after:"+((data/100)*(coordinateHeight!!.toFloat())).toInt()+"before:"+coordinateHeight!!.toFloat())
        var rect:Rect = Rect(pix.toInt(),-((data/100)*coordinateHeight!!.toFloat()).toInt(),
            (pix+0.13*coordinateWidth!!).toInt(),-PixelUtil.dp2px(context ,1.toFloat()))

        canvas?.drawRect(rect,framePaint)
        canvas?.drawRect(rect,insidePaint)


        if(title!= null) {
            canvas?.drawText(
                title,
                (pix+0.07*coordinateWidth!!).toFloat(),
                (mergin*coordinateHeight!!).toFloat(),
                coordinatePaint
            )
            canvas?.drawText("$data%",(pix+0.07*coordinateWidth!!).toFloat(),
                -((data/100)*coordinateHeight!!.toFloat()).toInt()-PixelUtil.dp2px(context, (12).toFloat()).toFloat(),dataPaint)
        }
    }

    fun setTextMargin(mergin :Double){
        this.mergin = mergin
    }
    fun setTextSize(size:Float){
        textWidth = size
    }
}