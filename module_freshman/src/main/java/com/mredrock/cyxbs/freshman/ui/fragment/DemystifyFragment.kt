package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapter.DemysityAdapter
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideExpressDeliveryBean
import com.mredrock.cyxbs.freshman.adapter.ExpressDeliveryViewPagerAdapter
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideDemystifyBean
import kotlinx.android.synthetic.main.freshman_fragment_demystify.*
import kotlinx.android.synthetic.main.freshman_fragment_express_delivery.*
import org.greenrobot.eventbus.Subscribe

/**
 * Created by Tree on 2019/8/3 10:15
 */
class DemystifyFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.freshman_fragment_demystify, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rc_demysify.layoutManager = LinearLayoutManager(activity as Context)
    }

    @Subscribe(sticky = true)
    fun acceptData(campusGuideDemystifyBean: CampusGuideDemystifyBean) {
        rc_demysify.adapter = DemysityAdapter(campusGuideDemystifyBean)
    }


}
