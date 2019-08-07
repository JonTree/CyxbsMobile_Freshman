package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapter.DemysityDetailViewPagerAdapter
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideDemystifyBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideManAndWomanBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean
import com.mredrock.cyxbs.freshman.util.gson
import kotlinx.android.synthetic.main.freshman_activity_demystify_detail.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class DemystifyDetailActivity : BaseActivity() {

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
            "          \"data\": \"0.89\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \"....\",\n" +
            "          \"data\": \"0.75\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \"....\",\n" +
            "          \"data\": \"0.69\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"学院\",\n" +
            "      \"message\": [\n" +
            "        {\n" +
            "          \"subject\": \".....\",\n" +
            "          \"data\": \"0.89\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \".....\",\n" +
            "          \"data\":\"0.78\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \".....\",\n" +
            "          \"data\": \"0.45\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    val data2 = "{\n" +
            "\t\"code\": 200,\n" +
            "\t\"info\": \"ok\",\n" +
            "\t\"title\": \"男女比例\",\n" +
            "\t\"text\": [{\n" +
            "\t\t\t\"name\": \"学院\",\n" +
            "\t\t\t\"boy\": \"11%\",\n" +
            "\t\t\t\"girl\": \"11%\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"name\": \"学院\",\n" +
            "\t\t\t\"boy\": \"11%\",\n" +
            "\t\t\t\"girl\": \"11%\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}"


    override val isFragmentActivity: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_demystify_detail)
        common_toolbar.init(
            title = "数据揭秘"
        )
        vp_demystify_detail.adapter = DemysityDetailViewPagerAdapter(
            this,
            gson.fromJson(data, CampusGuideSubjectBean::class.java),
            gson.fromJson(data2, CampusGuideManAndWomanBean::class.java),
            intent.getIntExtra("position",-1)
        )
        tl_demystify_detail.setupWithViewPager(vp_demystify_detail)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(a: CampusGuideDemystifyBean) {
        LogUtils.d("MyTag", "do")
    }

}
