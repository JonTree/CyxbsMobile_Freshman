package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Scroller
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.event.UpdataViewPagerAutoSlideEvent
import com.mredrock.cyxbs.freshman.util.DormitoryCarouselViewPagerAdapter
import com.mredrock.cyxbs.freshman.util.DormitoryViewPagerAdapter
import com.mredrock.cyxbs.freshman.util.ExpressDeliveryViewPagerAdapter
import kotlinx.android.synthetic.main.freshman_fragment_dormitory.*
import kotlinx.android.synthetic.main.freshman_fragment_express_delivery.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import android.view.animation.Interpolator
import kotlinx.android.synthetic.main.freshman_view_pager_item_carousel.*


/**
 * Created by Tree on 2019/8/2 23:19
 */
class DormitoryFragment : BaseFragment() {

    private var isPause = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(com.mredrock.cyxbs.freshman.R.layout.freshman_fragment_dormitory, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    @Subscribe(sticky = true)
    fun onBeanReady(bean: CampusGuideBasicBean){
        vp_dormitory.adapter = DormitoryViewPagerAdapter(activity as Context,bean.text[0])
        tl_dormitory.setupWithViewPager(vp_dormitory)


        vp_dormitory_carousel.adapter = DormitoryCarouselViewPagerAdapter(activity as Context,bean.text[0])
        vp_dormitory_carousel.currentItem = ((Int.MAX_VALUE/2) -1)
//        vp_dormitory_carousel.setOnTouchListener { _, event ->
//            when (event.action) {
//                MotionEvent.ACTION_DOWN -> isPause = true
//                MotionEvent.ACTION_UP -> isPause = false
//            }
//            return@setOnTouchListener false
//        }


        try {
            val aClass = ViewPager::class.java
            val sInterpolator = aClass.getDeclaredField("sInterpolator")
            sInterpolator.isAccessible = true
            val scroller = object : Scroller(activity, sInterpolator.get(vp_dormitory_carousel) as Interpolator) {
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


        Thread{
            while (true) {
                Thread.sleep(3000)
                if (isPause) {
                    continue
                }
                EventBus.getDefault().post(UpdataViewPagerAutoSlideEvent())
            }
        }.start()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun updataViewPagerAutoSlide(event: UpdataViewPagerAutoSlideEvent) {
        vp_dormitory_carousel.apply {
            currentItem += 1
        }
    }


}
