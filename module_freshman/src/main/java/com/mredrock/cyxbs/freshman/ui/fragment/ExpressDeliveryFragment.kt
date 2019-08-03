package com.mredrock.cyxbs.freshman.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.ExpressDeliveryViewPagerAdapter
import kotlinx.android.synthetic.main.freshman_fragment_express_delivery.*

/**
 * Created by Tree on 2019/8/3 10:02
 */
class ExpressDeliveryFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.freshman_fragment_express_delivery,container)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vp_express_delivery.adapter = ExpressDeliveryViewPagerAdapter()
        tl_express_delivery.setupWithViewPager(vp_express_delivery)

    }
}
