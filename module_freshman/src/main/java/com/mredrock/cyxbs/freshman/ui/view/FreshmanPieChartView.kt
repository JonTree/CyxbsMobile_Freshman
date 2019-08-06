package com.mredrock.cyxbs.freshman.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.util.PixelUtil
import kotlin.math.cos
import kotlin.math.sin

class FreshmanPieChartView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val coordinatePaint = Paint()
    private val pinkFillingPaint = Paint()
    private val lightBlueFillingPaint = Paint()
    private val dataPaint = Paint()

    var mProportion :Float = 0.1.toFloat()
    var textSize = PixelUtil.sp2px(context,20.toFloat()).toFloat()
    var storkeWidth = PixelUtil.dp2px(context,1.toFloat()).toFloat()
    private var radius :Int? = null
    init {
        coordinatePaint.color = Color.rgb(105,138,255)
        pinkFillingPaint.color = Color.rgb(255,115,184)
        lightBlueFillingPaint.color = Color.rgb(60,206,255)
        dataPaint.color = Color.rgb(255,255,255)

        coordinatePaint.strokeWidth = storkeWidth
        coordinatePaint.style = Paint.Style.FILL_AND_STROKE
        dataPaint.style = Paint.Style.FILL_AND_STROKE

        pinkFillingPaint.style = Paint.Style.FILL
        lightBlueFillingPaint.style = Paint.Style.FILL

        coordinatePaint.textSize = textSize
        dataPaint.textSize = textSize

        coordinatePaint.textAlign = Paint.Align.CENTER
        dataPaint.textAlign = Paint.Align.CENTER
//        dataPaint.textAlign = Paint.Align.RIGHT

    }
    private var viewWidth:Int? = null
    private var viewHeight:Int? = null

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)
        radius = (0.26*viewWidth!!).toInt()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawTitle(canvas)
        drawPieChart(canvas)
    }

    private fun drawTitle(canvas: Canvas?){

        val rectMan :Rect = Rect((0.1*viewWidth!!).toInt(),(0.06*viewHeight!!).toInt(),(0.17*viewWidth!!).toInt(),(0.11*viewHeight!!).toInt())

        canvas?.drawRect(rectMan,coordinatePaint)
        canvas?.drawRect(rectMan,lightBlueFillingPaint)
        canvas?.drawText("男",(0.195*viewWidth!!).toFloat(),(0.085*viewHeight!!).toFloat(),coordinatePaint)

        canvas?.save()
        canvas?.translate(0.toFloat(),(0.15*viewHeight!!).toFloat())
        val rectWoman :Rect = Rect((0.1*viewWidth!!).toInt(),(0.06*viewHeight!!).toInt(),(0.17*viewWidth!!).toInt(),(0.11*viewHeight!!).toInt())

        canvas?.drawRect(rectWoman,coordinatePaint)
        canvas?.drawRect(rectWoman,pinkFillingPaint)
        canvas?.drawText("女",(0.195*viewWidth!!).toFloat(),(0.085*viewHeight!!).toFloat(),coordinatePaint)

        canvas?.restore()
    }
    fun setManProportion(proportion : Float){
        mProportion = proportion
        postInvalidate()
    }

    private fun drawPieChart(canvas: Canvas?){
        var girlTextPointAngle =  (360-mProportion*360)/2
//        var boyTextPointAngle = (mProportion*360)
        canvas?.save()
        canvas?.translate((0.5*viewWidth!!).toFloat(),(0.57*viewHeight!!).toFloat())

        coordinatePaint.style = Paint.Style.STROKE
        LogUtils.d("MyTag","360-mProportion*360=${360-mProportion*360}")
        val rect :RectF = RectF(-radius!!.toFloat(),-radius!!.toFloat(),radius!!.toFloat(),radius!!.toFloat())
        canvas?.save()
        canvas?.rotate(90.toFloat())
        canvas?.drawArc(rect,0.toFloat(),(360-mProportion*360),true,pinkFillingPaint)
        canvas?.drawArc(rect,0.toFloat(),(360-mProportion*360),true,coordinatePaint)

        canvas?.drawArc(rect,(360-mProportion*360),mProportion*360,true,lightBlueFillingPaint)
        canvas?.drawArc(rect,(360-mProportion*360),mProportion*360,true,coordinatePaint)

        coordinatePaint.style = Paint.Style.FILL_AND_STROKE

        canvas?.restore()
        var woProporation  = 1-mProportion
        val woman :String = String.format("%.2f",(woProporation*100))
        val man :String = String.format("%.2f",(mProportion*100))
        LogUtils.d("MyTag","$girlTextPointAngle  ")

        var girlTag = 0.5f
        var boyTag = 0.5f
        if(girlTextPointAngle<45){
            girlTag = 0.66f
            boyTag = 0.33f
        }
        if(girlTextPointAngle<25){
            girlTag = 0.8f

        }
        if(girlTextPointAngle>135){
            girlTag = 0.33f
            boyTag = 0.66f
        }
        if(girlTextPointAngle>155){
            boyTag = 0.8f

        }
        LogUtils.d("MyTag","girl$girlTextPointAngle cos${cos(girlTextPointAngle)}")

        canvas?.drawText("$woman%",-sin(girlTextPointAngle*0.017f)*radius!!*girlTag,cos(girlTextPointAngle*0.017f)*radius!!*girlTag,dataPaint)


        canvas?.drawText("$man%",sin(girlTextPointAngle*0.017f)*radius!!*boyTag, -cos(girlTextPointAngle*0.017f)*radius!!*boyTag,dataPaint)
    }
}