package com.mredrock.cyxbs.freshman.ui.acivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapter.DemysityDetailAdapter
import com.mredrock.cyxbs.freshman.adapter.DormitoryCarouselViewPagerAdapter
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideDemystifyBean
import com.mredrock.cyxbs.freshman.util.gson
import kotlinx.android.synthetic.main.freshman_activity_demystify_detail.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class DemystifyDetailActivity : BaseActivity() {

    val data = "{\n" +
            "\t\"code\": 200,\n" +
            "\t\"info\": \"ok\",\n" +
            "\t\"text\": [{\n" +
            "\t\t\t\"name\": \"学院\",\n" +
            "\t\t\t\"message\": [{\n" +
            "\t\t\t\t\t\"title\": \"最难科目\",\n" +
            "\t\t\t\t\t\"data\": [{\n" +
            "\t\t\t\t\t\t\"subject\": \"数学\",\n" +
            "\t\t\t\t\t\t\"data\": \"0.2\"\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"subject\": \"物理\",\n" +
            "\t\t\t\t\t\t\"data\": \"0.38\"\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"subject\": \"物理\",\n" +
            "\t\t\t\t\t\t\"data\": \"0.16\"\n" +
            "\t\t\t\t\t}]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"title\": \"男女比例\",\n" +
            "\t\t\t\t\t\"boy\": \"20%\",\n" +
            "\t\t\t\t\t\"girl\": \"80%\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"name\": \"学院\",\n" +
            "\t\t\t\"message\": [{\n" +
            "\t\t\t\t\t\"title\": \"最难科目\",\n" +
            "\t\t\t\t\t\"data\": [{\n" +
            "\t\t\t\t\t\t\"subject\": \"数学\",\n" +
            "\t\t\t\t\t\t\"data\": \"80%\"\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"subject\": \"物理\",\n" +
            "\t\t\t\t\t\t\"data\": \"80%\"\n" +
            "\t\t\t\t\t}]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"title\": \"男女比例\",\n" +
            "\t\t\t\t\t\"boy\": \"20%\",\n" +
            "\t\t\t\t\t\"girl\": \"80%\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
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

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(a:CampusGuideDemystifyBean){
        LogUtils.d("MyTag","do")
        vp_demystify_detail.adapter = DemysityDetailAdapter(this,a.text[0].message[0])
    }

    override fun onResume() {





        super.onResume()
        val a = gson.fromJson(data, CampusGuideDemystifyBean::class.java)
        vp_demystify_detail.adapter = DemysityDetailAdapter(this,a.text[0].message[0])
    }
}
