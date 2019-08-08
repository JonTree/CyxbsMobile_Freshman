package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.ProcessViewModel

class ProcessActivity : BaseViewModelActivity<ProcessViewModel>() {
    override val viewModelClass: Class<ProcessViewModel> = ProcessViewModel::class.java
    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_process)


    }
}
