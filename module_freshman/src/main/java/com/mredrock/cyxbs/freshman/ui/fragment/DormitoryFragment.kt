package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.util.DormitoryViewPagerAdapter
import com.mredrock.cyxbs.freshman.util.ExpressDeliveryViewPagerAdapter
import kotlinx.android.synthetic.main.freshman_fragment_dormitory.*
import kotlinx.android.synthetic.main.freshman_fragment_express_delivery.*
import org.greenrobot.eventbus.Subscribe

/**
 * Created by Tree on 2019/8/2 23:19
 */
class DormitoryFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.freshman_fragment_dormitory, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    @Subscribe(sticky = true)
    fun onBeanReady(bean: CampusGuideBasicBean){
        vp_dormitory.adapter = DormitoryViewPagerAdapter(activity as Context)
        tl_dormitory.setupWithViewPager(vp_dormitory)
    }
}
