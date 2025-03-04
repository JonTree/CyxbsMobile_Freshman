package com.mredrock.cyxbs.freshman.adapter

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.text.Html
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerPageGuidedBusWayBinding
import com.mredrock.cyxbs.freshman.event.GuideDataEvent
import com.mredrock.cyxbs.freshman.util.Util
import com.mredrock.cyxbs.freshman.util.PixelUtil
import kotlinx.android.synthetic.main.freshman_route_bus_item.view.*
import kotlinx.android.synthetic.main.freshman_route_bus_item_item.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_page_guided_bus_way.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_page_guided_campus_landscape.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_page_guided_campus_landscape_item.view.*
import org.jetbrains.anko.windowManager
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.freshman.ui.acivity.showPhotos
import com.mredrock.cyxbs.freshman.updata.IMAGE_BASE_URI
import org.jetbrains.anko.toast


/**
 * Created by Tree on 2019/8/7 16:24
 */
class GuideViewPagerAdapter(val context: Context, private val guideDataEvent: GuideDataEvent) : PagerAdapter() {


    private val titleList = listOf("公交路线", "校园风光")

    private val isOpens = mutableListOf<Boolean>()

    private val onClickViews = mutableListOf<View>()

    private val heightList = mutableListOf<Int>()

    private val itemList = mutableListOf<View>()

    private val pagerList = ArrayList<View>()

    private val windowWidth:Int
    init {
        val outMetrics = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(outMetrics)
        windowWidth = outMetrics.widthPixels
        guideDataEvent.guideBusBean.text_2.message.forEach { _ -> isOpens.add(false) }
        pagerList.add(View.inflate(
            context,
            R.layout.freshman_view_pager_page_guided_bus_way,
            null
        ).apply {

            this.tv_bus_way_copy.setOnClickListener {
                val  mClipData = ClipData.newPlainText("Label",guideDataEvent.guideBusBean.text_1.message)
                (context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).primaryClip = mClipData
                Toast.makeText(context,"复制成功",Toast.LENGTH_SHORT).show()
            }
            DataBindingUtil.bind<FreshmanViewPagerPageGuidedBusWayBinding>(this)?.bean = guideDataEvent.guideBusBean
            for (msg in guideDataEvent.guideBusBean.text_2.message) {
                LogUtils.d("MyTag0", "${ll_guide_bus_routes_item == null}")
                ll_guide_bus_routes_item.addView(
                    View.inflate(//生成子项
                        context,
                        R.layout.freshman_route_bus_item,
                        null
                    ).apply XML@{
                        //子项初始化
                        itemList.add(this)
                        val index = guideDataEvent.guideBusBean.text_2.message.indexOf(msg)//获取当前子项在推荐路线里面的索引
                        onClickViews.add(this.ll_guide_on_clik.apply {
                            //给子项整个设置点击事件
                            setOnClickListener {
                                if (isOpens.filter { it }.count() == 0) {
                                    animation(this@XML.ll_route_bus__item, isOpens[index],heightList[index])
                                    isOpens[index] = !isOpens[index]
                                }else if (isOpens.filter { it }.count() > 0) {
                                    for (i in 0 until isOpens.size) {
                                        if (isOpens[i]) {
                                            if (this == onClickViews[i]) {
                                                animation(this@XML.ll_route_bus__item, isOpens[index],heightList[index])
                                                isOpens[index] = !isOpens[index]
                                                break
                                            }else{
                                                closeItem(itemList[i].ll_route_bus__item,this@XML.ll_route_bus__item,heightList[i],heightList[index])
                                                isOpens[i] = !isOpens[i]
                                                isOpens[index] = !isOpens[index]
                                                break
                                            }
                                        }
                                    }
                                }
                            }
                        })
                        this.tv_bus_route_title.text = msg.name
                        for (route in msg.route) {
                            val view = View.inflate(
                                context,
                                R.layout.freshman_route_bus_item_item,
                                null
                            ).apply {
                                val title = "路线${convertingNumbers(msg.route.indexOf(route))}"
                                this.tv_route_title.text = title
                                val detail =
                                    "<font color='#5b69ff'>${route.substringBefore("→")}</font>→${route.substringAfter(
                                        "→"
                                    ).substringBeforeLast("→")}→<font color='#b573ff'>${route.substringAfterLast(
                                        "→"
                                    )}</font>"
                                this.tv_route_detail.text = Html.fromHtml(detail)
                            }

                            this.ll_route_bus__item.addView(//子项的容器
                                view
                            )
                        }
                        this.ll_route_bus__item.measure(View.MeasureSpec.makeMeasureSpec(windowWidth-PixelUtil.dp2px(context,70.toFloat()),View.MeasureSpec.AT_MOST),
                            View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED))
                        heightList.add(this.ll_route_bus__item.measuredHeight)
                        ll_route_bus__item.layoutParams = LinearLayout.LayoutParams(ll_route_bus__item.measuredWidth,0)
                    })
            }
        })

        pagerList.add(
            View.inflate(//第二个页面生成
                context,
                R.layout.freshman_view_pager_page_guided_campus_landscape,
                null
            ).apply {
                Util.loadImage(this.image_view_tiltle, guideDataEvent.campusSightseeingBean.text.title,null)
                this.tv_tiltle.text = guideDataEvent.campusSightseeingBean.text.title
                //第二个页面初始化
                var viewItem:View? = null
                if (guideDataEvent.campusSightseeingBean.text.message != null) {
                    for (msg in guideDataEvent.campusSightseeingBean.text.message) {//遍历图片msg
                        if (guideDataEvent.campusSightseeingBean.text.message.indexOf(msg) % 2 != 0) {
                            ll_guide_scenery_container.addView(
                                viewItem?.apply {
                                    Util.loadImage(this.image_view_sight_seeing_tiltle2, "$IMAGE_BASE_URI${msg.photo}", null)
                                    this.tv_sight_title2.text = msg.name
                                    this.image_view_sight_seeing_tiltle2.setOnClickListener {
                                        showPhotos(context,guideDataEvent.campusSightseeingBean.text.message.map { "$IMAGE_BASE_URI${it.photo}" },guideDataEvent.campusSightseeingBean.text.message.indexOf(msg))
                                    }
                                    Util.loadImage(this.image_view_sight_seeing_tiltle1, "$IMAGE_BASE_URI${guideDataEvent.campusSightseeingBean.text.message[guideDataEvent.campusSightseeingBean.text.message.indexOf(msg)-1].photo}", null)
                                    this.tv_sight_title1.text =  guideDataEvent.campusSightseeingBean.text.message[guideDataEvent.campusSightseeingBean.text.message.indexOf(msg)-1].name
                                    this.image_view_sight_seeing_tiltle1.setOnClickListener {
                                        showPhotos(context,guideDataEvent.campusSightseeingBean.text.message.map {"$IMAGE_BASE_URI${it.photo}"},guideDataEvent.campusSightseeingBean.text.message.indexOf(msg)-1)
                                    }
                                }
                            )
                        } else {
                            viewItem =  ViewGroup.inflate(context, R.layout.freshman_view_pager_page_guided_campus_landscape_item, null)
                            if (guideDataEvent.campusSightseeingBean.text.message.lastIndex
                                == guideDataEvent.campusSightseeingBean.text.message.indexOf(msg)
                            ) {
                                ll_guide_scenery_container.addView(
                                    viewItem?.apply {
                                        Util.loadImage(this.image_view_sight_seeing_tiltle1, msg.photo, null)

                                        this.image_view_sight_seeing_tiltle1.setOnClickListener {
                                            showPhotos(context,guideDataEvent.campusSightseeingBean.text.message.map { it.photo },guideDataEvent.campusSightseeingBean.text.message.indexOf(msg))
                                        }
                                        this.tv_sight_title1.text = msg.name
                                        this.ll_last.visibility = View.INVISIBLE
                                    }
                                )
                            }
                        }
                    }
                }

            }
        )
    }

    private fun animation(view: LinearLayout, isOpen: Boolean,height:Int) {
        LogUtils.d("MyTag", "animation $isOpen")
        LogUtils.d("MyTag","${view.measuredHeight}")
        if (isOpen) {
//            val objectAnimator = ObjectAnimator.ofInt(view, "alpha", 1, 0)
//            view.clearAnimation()
//            objectAnimator.duration = 100
//            objectAnimator.start()
            val valueAnimatorClose = ValueAnimator.ofInt(height,0)

//            view.layoutParams.height = 0
//            view.invalidate()

            valueAnimatorClose.duration = 500
            valueAnimatorClose.addUpdateListener {
                    view.layoutParams = LinearLayout.LayoutParams(view.measuredWidth,it.animatedValue as Int)
                LogUtils.d("MyTag","doAnimation")
            }

            valueAnimatorClose.start()
        } else {
//            val objectAnimator = ObjectAnimator.ofInt(view, "scaleY", 0, 1)
//            objectAnimator.duration = 100
//            view.clearAnimation()
//            objectAnimator.start()
            val valueAnimatorOpen = ValueAnimator.ofInt(0,height)
            valueAnimatorOpen.duration = 500
            valueAnimatorOpen.addUpdateListener {
                view.layoutParams = LinearLayout.LayoutParams(view.measuredWidth,it.animatedValue as Int)
            }
            valueAnimatorOpen.start()
        }
    }

    fun closeItem(closeView:LinearLayout,openView:LinearLayout,heightCloseView:Int,heightOpenView: Int){
        val set = AnimatorSet()
        val animations = mutableListOf<Animator>()


        val closeAnimator = ValueAnimator.ofInt(heightCloseView,0)
        closeAnimator.duration = 500
        closeAnimator.addUpdateListener {
            closeView.layoutParams = LinearLayout.LayoutParams(closeView.measuredWidth,it.animatedValue as Int)
        }
        val openAnimator = ValueAnimator.ofInt(0,heightOpenView)
        openAnimator.duration = 500
        openAnimator.addUpdateListener {
            openView.layoutParams = LinearLayout.LayoutParams(openView.measuredWidth,it.animatedValue as Int)
        }

        set.playTogether(closeAnimator,openAnimator)
        set.start()
    }

    fun convertingNumbers(num: Int): String {
        val list = listOf("一", "二", "三", "四", "五", "六", "七", "八", "九", "十")
        if (num > 9) {
            return ""
        }
        return list[num]
    }

    override fun getCount(): Int {
        return pagerList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(pagerList[position])
        return pagerList[position]
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(pagerList[position])
    }


}
