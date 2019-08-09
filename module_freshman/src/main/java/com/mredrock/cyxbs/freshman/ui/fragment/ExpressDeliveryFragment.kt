package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideExpressDeliveryBean
import com.mredrock.cyxbs.freshman.adapter.ExpressDeliveryViewPagerAdapter
import kotlinx.android.synthetic.main.freshman_fragment_express_delivery.*
import org.greenrobot.eventbus.Subscribe

/**
 * Created by Tree on 2019/8/3 10:02
 */
class ExpressDeliveryFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.freshman_fragment_express_delivery,null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    @Subscribe(sticky = true)
    fun onBeanReady(bean: CampusGuideExpressDeliveryBean){
        vp_express_delivery.adapter =
            ExpressDeliveryViewPagerAdapter(activity as Context, bean)
        tl_express_delivery.setupWithViewPager(vp_express_delivery)
    }
}
