package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapter.GuideViewPagerAdapter
import com.mredrock.cyxbs.freshman.data.ViewModel.GuidedViewModel
import com.mredrock.cyxbs.freshman.data.bean.GuideBusBean
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
            "      \"route\": [\"江北机场乘坐三号线→南坪站下车从5号出口出站→乘坐346/347路公交车→邮电大学站下车\",\"乘坐机场大巴→上清寺后下车乘坐108路公交车→南坪站转乘346/347路公交车→邮电大学站下车\"]\n" +
            "    },\n" +
            "      {\n" +
            "      \"name\": \"重庆火车北站北广场/南广场\",\n" +
            "      \"route\": [\"江北机场乘坐三号线→南坪站下车从5号出口出站→乘坐346/347路公交车→邮电大学站下车\",\"乘坐机场大巴→上清寺后下车乘坐108路公交车→南坪站转乘346/347路公交车→邮电大学站下车\"]\n" +
            "    }\n" +
            "    ]\n" +
            "  }\n" +
            "}"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_guided)

        vp_guided.adapter = GuideViewPagerAdapter(this, gson.fromJson(data, GuideBusBean::class.java))
        tl_guided.setupWithViewPager(vp_dormitory)
    }
}
