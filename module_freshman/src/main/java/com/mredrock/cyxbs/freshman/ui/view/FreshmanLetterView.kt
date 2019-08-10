package com.mredrock.cyxbs.freshman.ui.view

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.PixelUtil

class FreshmanLetterView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var animationTag = true

    val bitLeftTop by lazy {   BitmapFactory.decodeResource(context.resources, R.mipmap.ic_top_left)}
    val bitRightTop by lazy { BitmapFactory.decodeResource(context.resources, R.mipmap.ic_top_right)}
    val bitLeftBottom by lazy { BitmapFactory.decodeResource(context.resources, R.mipmap.ic_bottom_left)}
    val bitRightBottom by lazy { BitmapFactory.decodeResource(context.resources, R.mipmap.ic_bottom_right)}

    private val rectTop = Rect()
    private val rectLeft = Rect()
    private val rectRight = Rect()
    private val rectBottmo = Rect()
    private val rectBackground = Rect()

    private val framePaint = Paint()
    private val backgroundPaint = Paint()
    private val frameBacgroundPaint = Paint()
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
    set(value) {field = value
                if(value != null) {
                    targetHeight = (0.92 * value).toInt()
                    frameHeight = ((0.92 * value)-PixelUtil.dp2px(context,4f)).toInt()
                    fillingHeight = ((0.92 * value)-PixelUtil.dp2px(context,7f)).toInt()
                }
    }
    private var viewWidth :Int? = null
        set(value) {field = value
            if(value != null){
                targetWidth = (0.872*value).toInt()
                frameWidth = ((0.872*value)-PixelUtil.dp2px(context,4f)).toInt()
                fillingWidth = ((0.872*value)-PixelUtil.dp2px(context,7f)).toInt()
            }
        }
    private var targetHeight :Int? = null
    private var targetWidth :Int? = null
    private var frameHeight :Int? = null
    private var frameWidth :Int? = null
    private var fillingHeight :Int? = null
    private var fillingWidth :Int? = null
    private var height :Int? = null
    private var width :Int? = null

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)

        setMeasuredDimension(viewWidth!!,viewHeight!!)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        if(height == null)
            height = 5/4*(bitLeftBottom.height+bitLeftTop.height)
        if(width == null)
            width = 10/9*(bitLeftTop.width+bitRightTop.width)

        moveCanvas(canvas)
        drawFrame(canvas)
        drawBackground(canvas)

        drawAngle(canvas)
        if(animationTag){
            animationTag = false
            doAnimation()
        }
    }
    private fun moveCanvas(canvas: Canvas?){
        canvas?.translate((viewWidth!!-width!!)/2f,(viewHeight!!-height!!)/2f)
    }
    private fun drawFrame(canvas: Canvas?){
        rectLeft.left = PixelUtil.dp2px(context,4f)
        rectLeft.top = PixelUtil.dp2px(context,7f)
        rectLeft.right = PixelUtil.dp2px(context,7f)
        rectLeft.bottom = height!!-PixelUtil.dp2px(context,7f)

//        rectLeft = Rect(PixelUtil.dp2px(context,4f),0,PixelUtil.dp2px(context,7f),viewHeight!!)
        rectTop.bottom = PixelUtil.dp2px(context,7f)
        rectTop.top = PixelUtil.dp2px(context,4f)
        rectTop.left = PixelUtil.dp2px(context,7f)
        rectTop.right = width!!-PixelUtil.dp2px(context,7f)
//        val rectTop = Rect(0,PixelUtil.dp2px(context,4f),viewWidth!!,PixelUtil.dp2px(context,7f))
        rectRight.left = width!!-PixelUtil.dp2px(context,7f)
        rectRight.top = PixelUtil.dp2px(context,7f)
        rectRight.right = width!!-PixelUtil.dp2px(context,4f)
        rectRight.bottom = height!!-PixelUtil.dp2px(context,7f)
//        val rectRight = Rect(viewWidth!!-PixelUtil.dp2px(context,7f),0,viewWidth!!-PixelUtil.dp2px(context,4f),viewHeight!!)
        rectBottmo.left = PixelUtil.dp2px(context,7f)
        rectBottmo.top = height!!-PixelUtil.dp2px(context,7f)
        rectBottmo.right = width!!-PixelUtil.dp2px(context,7f)
        rectBottmo.bottom = height!!-PixelUtil.dp2px(context,4f)


        canvas?.drawRect(rectLeft,framePaint)
        canvas?.drawRect(rectLeft,frameBacgroundPaint)
        canvas?.drawRect(rectTop,framePaint)
        canvas?.drawRect(rectTop,frameBacgroundPaint)
        canvas?.drawRect(rectRight,framePaint)
        canvas?.drawRect(rectRight,frameBacgroundPaint)
        canvas?.drawRect(rectBottmo,framePaint)
        canvas?.drawRect(rectBottmo,frameBacgroundPaint)
    }

    private fun drawBackground(canvas: Canvas?){
        rectBackground.top = PixelUtil.dp2px(context,7f)
        rectBackground.left = PixelUtil.dp2px(context,7f)
        rectBackground.right = width!!-PixelUtil.dp2px(context,7f)
        rectBackground.bottom = height!!-PixelUtil.dp2px(context,7f)

        canvas?.drawRect(rectBackground,backgroundPaint)
    }
    private fun drawAngle(canvas: Canvas?){
        canvas?.drawBitmap(bitLeftTop,0f,0f,null)
        canvas?.drawBitmap(bitRightTop,width!!.toFloat()-bitRightTop.width,0f,null)
        canvas?.drawBitmap(bitLeftBottom,0f,height!!.toFloat()-bitLeftBottom.height,null)
        canvas?.drawBitmap(bitRightBottom,width!!.toFloat()-bitRightBottom.width,height!!.toFloat()-bitRightBottom.height,null)
    }
    private fun doAnimation(){
        val heightAnimation = ValueAnimator.ofInt(height!!,targetHeight!!)
        val wightAnimation = ValueAnimator.ofInt(width!!,targetWidth!!)

        heightAnimation.addUpdateListener {
            height = it.animatedValue as Int
            LogUtils.d("MyTag","animationa")
            invalidate()

        }

        wightAnimation.addUpdateListener {
            width = it.animatedValue as Int
            invalidate()

        }


        val set = AnimatorSet()
        set.duration = 1000
        set.playTogether(heightAnimation,wightAnimation)
        set.addListener(object : AnimationDoneListener, Animator.AnimatorListener {
            override fun onAnimationDone() {
                listener?.onAnimationDone()
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
        set.start()
    }

    var listener:AnimationDoneListener? = null
    fun setOnAnimationDoneListener(listener:AnimationDoneListener){
        this.listener = listener
    }
    interface AnimationDoneListener{
        fun onAnimationDone()
    }

}