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
import kotlinx.android.synthetic.main.freshman_view_pager_dormitory_page.*


/**
 * Created by Tree on 2019/8/2 23:19
 */
class DormitoryFragment : BaseFragment() {


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



    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun updataViewPagerAutoSlide(event: UpdataViewPagerAutoSlideEvent) {
        event.viewPager.apply {
            currentItem += 1
        }
    }


}
