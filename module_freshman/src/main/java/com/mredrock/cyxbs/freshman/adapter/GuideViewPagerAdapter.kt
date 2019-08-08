package com.mredrock.cyxbs.freshman.adapter

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.BusWayBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerPageGuidedBusWayBinding
import com.mredrock.cyxbs.freshman.ui.view.AnimationLinearLayout
import kotlinx.android.synthetic.main.freshman_route_bus_item.view.*
import kotlinx.android.synthetic.main.freshman_route_bus_item_item.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_page_guided_bus_way.view.*

/**
 * Created by Tree on 2019/8/7 16:24
 */
class GuideViewPagerAdapter(val context: Context, val bean: BusWayBean) : PagerAdapter() {


    val titleList = listOf("公交路线", "校园风光")

    val isOpens = mutableListOf<Boolean>()

    val onClickViews = mutableListOf<View>()

    private val pagerList = ArrayList<View>()

    init {
        bean.text_2.message.forEach { isOpens.add(false) }
        pagerList.add(View.inflate(
            context,
            R.layout.freshman_view_pager_page_guided_bus_way,
            null
        ).apply {
            DataBindingUtil.bind<FreshmanViewPagerPageGuidedBusWayBinding>(this)?.bean = bean
            for (msg in bean.text_2.message) {
                LogUtils.d("MyTag0", "${ll_guide_bus_routes_item == null}")
                ll_guide_bus_routes_item.addView(
                    View.inflate(//生成子项
                        context,
                        R.layout.freshman_route_bus_item,
                        null
                    ).apply XML@{
                        //子项初始化
                        val index = bean.text_2.message.indexOf(msg)//获取当前子项在推荐路线里面的索引
                        onClickViews.add(this.ll_guide_on_clik.apply {
                            //给子项整个设置点击事件
                            setOnClickListener {
                                for (view in onClickViews){//所有展开的都关闭
                                    if (onClickViews.indexOf(view) !=index) {//若是当前点击的view，不做设置
                                        isOpens[onClickViews.indexOf(view)] = false
//                                        view.ll_route_bus__item.visibility = View.GONE
                                    }
                                }
                                animation(this@XML.ll_route_bus__item, isOpens[index])
                                isOpens[index] = !isOpens[index]
                            }
                        })
                        LogUtils.d("MyTag2", "${this.ll_guide_bus_routes_item == null}")
                        this.tv_bus_route_title.text = msg.name
                        for (route in msg.route) {
                            this.ll_route_bus__item.addView(
                                View.inflate(
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
                            )
                        }
                    })
            }
        })
    }

    @SuppressLint("ObjectAnimatorBinding")
    private fun animation(view: LinearLayout, isOpen: Boolean) {
        LogUtils.d("MyTag", "animation")
        if (isOpen) {
            val objectAnimator = ObjectAnimator.ofInt(view, "scaleY", 1, 0)
            objectAnimator.duration = 1000
            objectAnimator.start()
        } else {
            val objectAnimator = ObjectAnimator.ofInt(view, "scaleY", 0, 1)
            objectAnimator.duration = 1000
            objectAnimator.start()
        }
    }


    fun convertingNumbers(num: Int): String {
        val list = listOf("一", "二", "三", "四", "五", "六", "七", "八", "九", "十")
        if (num in 1..10) {
            return list[num - 1]
        }
        return ""
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
