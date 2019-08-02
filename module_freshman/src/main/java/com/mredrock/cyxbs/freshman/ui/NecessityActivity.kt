package com.mredrock.cyxbs.freshman.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R

class NecessityActivity : BaseActivity() {
    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_admission_must)
    }
}
