package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.Interpolator
import android.widget.Scroller
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerDormitoryAndCanteenPageBinding
import com.mredrock.cyxbs.freshman.event.UpdataViewPagerAutoSlideEvent
import kotlinx.android.synthetic.main.freshman_view_pager_dormitory_and_canteen_page.view.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by Tree on 2019/8/3 22:37
 */
class DormitoryViewPagerAdapter(val context: Context, val bean: CampusGuideBasicBean.TextBean) : PagerAdapter() {


    private val pagerList = ArrayList<View>()

    private var isPause = false


    init {
        for (msg in bean.message) {
            val view = View.inflate(
                context,
                R.layout.freshman_view_pager_dormitory_and_canteen_page,
                null
            ).apply {
                vp_dormitory_carousel.adapter =
                    DormitoryCarouselViewPagerAdapter(context as Context, bean)
                vp_dormitory_carousel.currentItem = ((Int.MAX_VALUE / 2) - 1)
                try {
                    val aClass = ViewPager::class.java
                    val sInterpolator = aClass.getDeclaredField("sInterpolator")
                    sInterpolator.isAccessible = true
                    val scroller =
                        object : Scroller(context, sInterpolator.get(vp_dormitory_carousel) as Interpolator) {
                            override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
                                //最后一个参数即viewpager自动滑动的时间
                                super.startScroll(startX, startY, dx, dy, 2000)
                            }
                        }
                    val mScroller = aClass.getDeclaredField("mScroller")
                    mScroller.isAccessible = true
                    mScroller.set(vp_dormitory_carousel, scroller)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                Thread {
                    while (true) {
                        Thread.sleep(3000)
                        if (isPause) {
                            continue
                        }
                        EventBus.getDefault().post(UpdataViewPagerAutoSlideEvent(vp_dormitory_carousel))
                    }
                }.start()
            }
            val bind = DataBindingUtil.bind<FreshmanViewPagerDormitoryAndCanteenPageBinding>(view)
            bind?.bean = msg
            pagerList.add(
                view
            )
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return bean.message[position].name
    }

    override fun getCount(): Int {
        return bean.message.size
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
