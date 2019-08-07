package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.content.Intent
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
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean
import com.mredrock.cyxbs.freshman.ui.acivity.DemystifyDetailActivity
import com.mredrock.cyxbs.freshman.util.gson
import kotlinx.android.synthetic.main.freshman_fragment_demystify.*
import kotlinx.android.synthetic.main.freshman_fragment_express_delivery.*
import org.greenrobot.eventbus.Subscribe

/**
 * Created by Tree on 2019/8/3 10:15
 */
class DemystifyFragment : BaseFragment() {


    val data = "{\n" +
            "  \"code\": 200,\n" +
            "  \"info\": \"ok\",\n" +
            "  \"title\": \"最难科目\",\n" +
            "  \"text\": [\n" +
            "    {\n" +
            "      \"name\": \"学院\",\n" +
            "      \"message\": [\n" +
            "        {\n" +
            "          \"subject\": \"....\",\n" +
            "          \"data\": \"....\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \"....\",\n" +
            "          \"data\": \"....\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \"....\",\n" +
            "          \"data\": \"....\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"学院\",\n" +
            "      \"message\": [\n" +
            "        {\n" +
            "          \"subject\": \".....\",\n" +
            "          \"data\": \"....\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \".....\",\n" +
            "          \"data\":\".....\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \".....\",\n" +
            "          \"data\": \".....\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.freshman_fragment_demystify, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rc_demysify.layoutManager = LinearLayoutManager(activity as Context)
        rc_demysify.adapter = DemysityAdapter(activity as Context,gson.fromJson(data,CampusGuideSubjectBean::class.java))
    }

}
