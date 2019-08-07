package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapter.GuideViewPagerAdapter
import com.mredrock.cyxbs.freshman.data.ViewModel.GuidedViewModel
import com.mredrock.cyxbs.freshman.data.bean.BusWayBean
import com.mredrock.cyxbs.freshman.util.gson
import kotlinx.android.synthetic.main.freshman_activity_guided.*
import kotlinx.android.synthetic.main.freshman_fragment_dormitory.*

class GuideActivity : BaseViewModelActivity<GuidedViewModel>() {
    override val viewModelClass: Class<GuidedViewModel> = GuidedViewModel::class.java

    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.

    val data = "{\n" +
            "  \"code\": 200,\n" +
            "  \"info\": \"ok\",\n" +
            "  \"text_1\": {\n" +
            "    \"title\": \"重庆邮电大学地址:\",\n" +
            "    \"message\": \"重庆市南岸区南山街道崇文路2号重庆邮电大学\"\n" +
            "  },\n" +
            "  \"text_2\": {\n" +
            "    \"title\": \"推荐线路:\",\n" +
            "    \"message\": [{\n" +
            "      \"name\": \"重庆火车北站北广场/南广场\",\n" +
            "      \"route\": [\"...\",\"....\"]\n" +
            "    },\n" +
            "      {\n" +
            "        \"name\": \"江北机场\",\n" +
            "        \"route\": [\"....\",\"......\"]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_guided)

        vp_guided.adapter = GuideViewPagerAdapter(this, gson.fromJson(data, BusWayBean::class.java))
        tl_guided.setupWithViewPager(vp_dormitory)

    }
}
