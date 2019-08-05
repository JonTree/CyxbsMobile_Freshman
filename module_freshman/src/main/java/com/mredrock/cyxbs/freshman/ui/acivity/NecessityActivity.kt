package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.NecessityViewModel
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.adapter.NecessityAdapter
import kotlinx.android.synthetic.main.freshman_activity_necessity.*
import org.greenrobot.eventbus.Subscribe

class NecessityActivity : BaseViewModelActivity<NecessityViewModel>() {
    override val viewModelClass: Class<NecessityViewModel> = NecessityViewModel::class.java
    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_necessity)



//        val vm : Deliverable = viewModel

        val viewModel = ViewModelProviders.of(this).get(NecessityViewModel::class.java)

    }



    @Subscribe(sticky = true)
    fun onBeanReady(bean:NecessityBean){

        res_necessity.adapter = NecessityAdapter(bean)
        res_necessity.layoutManager = LinearLayoutManager(this)

    }

}
