package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import android.transition.Fade
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.adapter.DemysityDetailViewPagerAdapter
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideManAndWomanBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean
import com.mredrock.cyxbs.freshman.util.gson
import kotlinx.android.synthetic.main.freshman_activity_demystify_detail.*
import kotlinx.android.synthetic.main.freshman_view_pager_page_demystify_male_female_ratio.*


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
            "          \"subject\": \"大学物理\",\n" +
            "          \"data\": \"0.89\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \"高等数学\",\n" +
            "          \"data\": \"0.75\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \"离散数学\",\n" +
            "          \"data\": \"0.69\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"学院\",\n" +
            "      \"message\": [\n" +
            "        {\n" +
            "          \"subject\": \"高等数学\",\n" +
            "          \"data\": \"0.89\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \"大学英语\",\n" +
            "          \"data\":\"0.78\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"subject\": \"大学物理\",\n" +
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
            "\t\t\t\"boy\": \"60%\",\n" +
            "\t\t\t\"girl\": \"11%\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"name\": \"学院\",\n" +
            "\t\t\t\"boy\": \"67%\",\n" +
            "\t\t\t\"girl\": \"11%\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}"

    var isFirst = true


    override val isFragmentActivity: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mredrock.cyxbs.freshman.R.layout.freshman_activity_demystify_detail)
        val fade = Fade()
        window.enterTransition = fade
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
        vp_demystify_detail.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (isFirst) {
                    if (position == 1) {
                        fpcv_man_woamn_data.doAnimation()
                        isFirst = false
                    }
                }
            }
        })
    }


}
