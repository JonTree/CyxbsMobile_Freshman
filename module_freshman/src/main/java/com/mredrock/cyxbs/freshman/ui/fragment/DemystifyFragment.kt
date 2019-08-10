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
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean
import kotlinx.android.synthetic.main.freshman_fragment_demystify.*
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

    }

    @Subscribe(sticky = true)
    fun upData(campusGuideSubjectBean: CampusGuideSubjectBean){
        rc_demysify.layoutManager = LinearLayoutManager(activity as Context)
        rc_demysify.adapter = DemysityAdapter(activity as Context,campusGuideSubjectBean)
    }

}
