package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import android.transition.Fade
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapter.ProcessRecyclerViewAdapter
import com.mredrock.cyxbs.freshman.data.ViewModel.ProcessViewModel
import com.mredrock.cyxbs.freshman.data.bean.ProcessBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanActivityProcessBinding
import kotlinx.android.synthetic.main.freshman_activity_process.*
import org.greenrobot.eventbus.Subscribe

class ProcessActivity : BaseViewModelActivity<ProcessViewModel>() {
    override val viewModelClass: Class<ProcessViewModel> = ProcessViewModel::class.java
    override val isFragmentActivity: Boolean = false
    //To change initializer of created properties use File | Settings | File Templates.

    lateinit var bind: FreshmanActivityProcessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView<FreshmanActivityProcessBinding>(this,R.layout.freshman_activity_process)
        common_toolbar.init(
            title = "入学流程"
        )
        recycle_view_process.layoutManager = LinearLayoutManager(this)
    }

    @Subscribe(sticky = true)
    fun upData(processBean: ProcessBean) {
        bind.bean = processBean
        recycle_view_process.adapter = ProcessRecyclerViewAdapter(processBean)

    }

}
