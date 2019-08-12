package com.mredrock.cyxbs.freshman.ui.view

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.util.PixelUtil

class FreshmanSuccessView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var viewWidth :Int? = null
    private var viewHeight :Int? = null
    private var degree :Float? =null

    private var rectF :RectF? = null
    private var rateLine1 :Float = 0f
    private var rateLine2 :Float = 0f
    private val paint = Paint()
    private var neverDoAnimation = true
    init {
        paint.color = Color.rgb(111,140,255)
        paint.strokeWidth = PixelUtil.dp2px(context,5.5f).toFloat()
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

//        LogUtils.d("MyTag","viewheight=$viewHeight viewWidth=$viewWidth")
        setMeasuredDimension(viewWidth!!,viewHeight!!)
    }

    override fun onDraw(canvas: Canvas?) {
//        canvas?.drawArc(0f,0f,350f,350f,0f,180f,false,paint)

//        canvas?.drawRect(0f,0f,viewWidth!!.toFloat(),viewHeight!!.toFloat(),paint)
        drawCircle(canvas)
        drawHook(canvas)
        if(neverDoAnimation){
            doAnimation()
            neverDoAnimation = false
        }
    }
    private fun drawCircle(canvas: Canvas?){
        if(rectF == null){
            rectF = RectF(-viewWidth!!/2+PixelUtil.dp2px(context,3f).toFloat(),-viewHeight!!/2+PixelUtil.dp2px(context,3f).toFloat(),viewWidth!!/2-PixelUtil.dp2px(context,3f).toFloat(),viewHeight!!/2-PixelUtil.dp2px(context,3f).toFloat())
        }
        canvas?.save()

        canvas?.translate(viewWidth!!/2f,viewHeight!!/2f)

        canvas?.rotate(180f)

        if(degree != null){
//            canvas?.drawArc(0f,0f,350f,350f,0f,180f,false,paint)
            canvas?.drawArc(rectF!!,0f,-degree!!,false,paint)
        }

        canvas?.restore()
    }

    private fun drawHook(canvas: Canvas?){
        canvas?.save()
        LogUtils.d("MyTag","viewHeight=${(1/4)*viewHeight!!} viewWidth =${1/4}")
        canvas?.translate((viewWidth!!/5f), (viewHeight!!/2f))
//        canvas?.translate((1/4*viewWidth!!).toFloat(), (1/2* viewHeight!!).toFloat())
//        canvas?.translate(100f,100f)

//        canvas?.drawLine(0f,0f,300f,300f,paint)

        canvas?.drawLine(0f,0f, rateLine1*((viewWidth!!/5f)+PixelUtil.dp2px(context,2.75f).toFloat()), rateLine1*(viewHeight!!/5f),paint)
        canvas?.translate((viewWidth!!/5f),(viewHeight!!/5f))
        canvas?.drawLine(0f,0f, rateLine2*(2f*viewWidth!!/5), -rateLine2*(2f*viewHeight!!/5),paint)
    }

    fun doAnimation(){
        LogUtils.d("animTag","success Do animation")
        degree = 0f
        rateLine1 = 0f
        rateLine2 = 0f
        val emptyAnimation = ValueAnimator.ofFloat(0f,1f)
        val circleAnimation = ValueAnimator.ofFloat(0f,360f)
        val line1Animation = ValueAnimator.ofFloat(0f,1f)
        val line2Animation = ValueAnimator.ofFloat(0f,1f)
        emptyAnimation.duration = 300
        circleAnimation.addUpdateListener {
            degree = it.animatedValue as Float
            invalidate()
        }
        line1Animation.addUpdateListener {
            rateLine1 = it.animatedValue as Float
            invalidate()
        }
        line2Animation.addUpdateListener {
            rateLine2 = it.animatedValue as Float
            invalidate()
        }

        val set = AnimatorSet()
        set.duration = 500
        set.playSequentially(circleAnimation,line1Animation,line2Animation,emptyAnimation)
        set.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                function?.invoke()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
        set.start()
    }
    private var function:(()->Unit)? =null
    fun setOnAnimationDoneListener(function:()->Unit){
        this.function = function
    }

}