package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import android.transition.Fade
import android.view.View
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapter.GuideViewPagerAdapter
import com.mredrock.cyxbs.freshman.data.ViewModel.GuidedViewModel
import com.mredrock.cyxbs.freshman.data.bean.CampusSightseeingBean
import com.mredrock.cyxbs.freshman.data.bean.GuideBusBean
import com.mredrock.cyxbs.freshman.event.GuideDataEvent
import com.mredrock.cyxbs.freshman.util.gson
import com.tencent.bugly.crashreport.common.strategy.StrategyBean
import kotlinx.android.synthetic.main.freshman_activity_guided.*
import kotlinx.android.synthetic.main.freshman_fragment_dormitory.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class GuideActivity : BaseViewModelActivity<GuidedViewModel>() {
    override val viewModelClass: Class<GuidedViewModel> = GuidedViewModel::class.java

    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_guided)
        common_toolbar.init(
            title = "指路重邮"
        )
        tl_guided.setupWithViewPager(vp_guided)
        common_toolbar.init(
            "指路重邮",R.drawable.common_ic_back,listener = View.OnClickListener { finish() })


    }

    @Subscribe(sticky = true)
    fun initData(guideDataEvent: GuideDataEvent){
        vp_guided.adapter = GuideViewPagerAdapter(this,guideDataEvent)
    }

}
