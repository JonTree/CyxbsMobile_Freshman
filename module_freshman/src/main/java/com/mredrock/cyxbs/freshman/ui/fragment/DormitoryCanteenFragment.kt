package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.event.UpdataViewPagerAutoSlideEvent
import com.mredrock.cyxbs.freshman.adapter.DormitoryViewPagerAdapter
import kotlinx.android.synthetic.main.freshman_fragment_dormitory.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.text.FieldPosition


/**
 * Created by Tree on 2019/8/2 23:19
 */
class DormitoryCanteenFragment(val position:Int): BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.freshman_fragment_dormitory, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (position) {
            0 -> tl_dormitory.tabMode = TabLayout.MODE_FIXED
            1 -> tl_dormitory.tabMode = TabLayout.MODE_SCROLLABLE
        }
    }
    @Subscribe(sticky = true)
    fun onBeanReady(bean: CampusGuideBasicBean){
        vp_dormitory.adapter =
            DormitoryViewPagerAdapter(activity as Context, bean.text[position])
//        tl_dormitory.setupWithViewPager(vp_dormitory)
    }

    @Synchronized
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun updataViewPagerAutoSlide(event: UpdataViewPagerAutoSlideEvent) {
        event.viewPager.apply {
            currentItem += 1
        }
    }
}
