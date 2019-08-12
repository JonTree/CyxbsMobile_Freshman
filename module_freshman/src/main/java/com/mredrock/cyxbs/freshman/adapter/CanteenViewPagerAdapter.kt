package com.mredrock.cyxbs.freshman.adapter

import android.annotation.SuppressLint
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
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideExpressDeliveryBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerCanteenPageBinding
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerDormitoryAndCanteenPageBinding
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerPageScrollViewItemExpressDeliveryBinding
import com.mredrock.cyxbs.freshman.event.UpdataViewPagerAutoSlideEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.freshman_fragment_cantenn.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_canteen_page.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_dormitory_and_canteen_page.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_express_delivery_page.view.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by Tree on 2019/8/5 20:04
 */
class CanteenViewPagerAdapter(val context: Context, val bean: CampusGuideBasicBean.TextBean, val viewPager: ViewPager) :
    PagerAdapter() {


    private val pagerList = ArrayList<View>()

    var carouselList = mutableListOf<ViewPager>()

    var position = 0

    init {
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                this@CanteenViewPagerAdapter.position = position
            }
        })

        for (msg in bean.message) {
            val view = View.inflate(
                context,
                R.layout.freshman_view_pager_canteen_page,
                null
            ).apply {
                carouselList.add(vp_canteen_carousel)
                vp_canteen_carousel.adapter =
                    DormitoryCarouselViewPagerAdapter(
                        context as Context,
                        bean.message[bean.message.indexOf(msg)].photos
                    )
                vp_canteen_carousel.currentItem = ((Int.MAX_VALUE / 2) - 1)
                try {
                    val aClass = ViewPager::class.java
                    val sInterpolator = aClass.getDeclaredField("sInterpolator")
                    sInterpolator.isAccessible = true
                    val scroller =
                        object : Scroller(context, sInterpolator.get(vp_canteen_carousel) as Interpolator) {
                            override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
                                //最后一个参数即viewpager自动滑动的时间
                                super.startScroll(startX, startY, dx, dy, 3000)
                            }
                        }
                    val mScroller = aClass.getDeclaredField("mScroller")
                    mScroller.isAccessible = true
                    mScroller.set(vp_canteen_carousel, scroller)
                } catch (e: Exception) {
                    e.printStackTrace()
                }


            }
            val bind = DataBindingUtil.bind<FreshmanViewPagerCanteenPageBinding>(view)
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
