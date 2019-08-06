package com.mredrock.cyxbs.freshman.ui.acivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import org.greenrobot.eventbus.Subscribe

class DemystifyDetailActivity : BaseActivity() {

    val data = ""


    override val isFragmentActivity: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_demystify_detail)
        common_toolbar.init(
            title = "数据揭秘"
        )



    }


}
