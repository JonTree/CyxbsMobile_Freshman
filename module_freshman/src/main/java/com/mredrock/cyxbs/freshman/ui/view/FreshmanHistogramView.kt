package com.mredrock.cyxbs.freshman.ui.view

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.AnimationSet
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
    private var firstDoOnDraw = true
    private val list :List<Paint> = listOf(blueFillingPaint,pinkFillingPaint,lightBlueFillingPaint)

    private var viewWidth :Float? = null
    private var coordinateWidth :Float = 0f

    private var viewHeight :Float? = null
    private var coordinateHeight :Float = 0f
    private val arrowConst = PixelUtil.dp2px(context,5.toFloat())
    private var mergin = 0.08
    private var paintWidth = PixelUtil.dp2px(context, 1.toFloat())
    private var textWidth = PixelUtil.sp2px(context,13.toFloat()).toFloat()
    private var valueAnimator:ValueAnimator? = null
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
    var title:List<String> = listOf("","","")
    var data = mutableListOf(0f,0f,0f)

    fun bindData(title:List<String>? ,data:List<Float>?){
        if (title != null && data != null) {
            this.title = title
            doAnimation(data)


        }

    }
    fun doCoordinationAnimation(){
        val horizentalAnimator = ValueAnimator.ofFloat(0f,viewWidth!!.toFloat()*0.95.toFloat())
        val verticalAnimator = ValueAnimator.ofFloat(0f,viewHeight!!.toFloat()*0.9.toFloat())
        horizentalAnimator.addUpdateListener {
            coordinateWidth = it.animatedValue as Float
            this.invalidate()
        }
        verticalAnimator.addUpdateListener {
            coordinateHeight = it.animatedValue as Float
            this.invalidate()
        }
        val set = AnimatorSet()
        set.playTogether(horizentalAnimator,verticalAnimator)
        set.setDuration(1400)
        set.start()
    }
    fun doAnimation(data: List<Float>){
        
        val valueAnimator1 = ValueAnimator.ofFloat(0f,data[0])
        val valueAnimator2 =  ValueAnimator.ofFloat(0f,data[1])
        val valueAnimator3 = ValueAnimator.ofFloat(0f,data[2])

       
//        valueAnimator1.duration = 1000
        valueAnimator1.addUpdateListener {
            this.data[0] = it.animatedValue as Float
            this.invalidate()
        }
//        valueAnimator2.duration = 1000
        valueAnimator2.addUpdateListener {
            this.data[1] = it.animatedValue as Float
            this.invalidate()
        }
//        valueAnimator3.duration = 1000
        valueAnimator3.addUpdateListener {
            this.data[2] = it.animatedValue as Float
            this.invalidate()
        }
        valueAnimator1.startDelay = 304
        valueAnimator2.startDelay = 730
        valueAnimator3.startDelay = 1156
        val set = AnimatorSet()
        set.playTogether(valueAnimator1,valueAnimator2,valueAnimator3)
        set.setDuration(1400)
        set.start()
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        viewWidth = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        coordinateWidth =0f
        viewHeight = MeasureSpec.getSize(heightMeasureSpec).toFloat()
        coordinateHeight = 0f
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
                drawRect(it, data[it], title[it],canvas,list[it])

            }
//        }
        if(firstDoOnDraw){
            firstDoOnDraw = false
            doCoordinationAnimation()
            
        }
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
            canvas?.drawText(String.format("%.2f",(data)),(pix+0.07*coordinateWidth!!).toFloat(),
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