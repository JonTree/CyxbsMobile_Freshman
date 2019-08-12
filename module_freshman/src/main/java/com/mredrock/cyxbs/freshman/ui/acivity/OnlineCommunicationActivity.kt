package com.mredrock.cyxbs.freshman.ui.acivity

import android.app.AlertDialog
import android.os.Bundle
import android.transition.Fade
import android.util.Log
import android.view.View
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.OnlineCommunicationViewModel
import kotlinx.android.synthetic.main.freshman_activity_online_communication.*
import com.mredrock.cyxbs.freshman.adapter.OnlineCommunicationViewPaggerAdapter
import com.mredrock.cyxbs.freshman.data.bean.GroupHomeBean
import com.mredrock.cyxbs.freshman.data.bean.GroupStudentBean
import com.mredrock.cyxbs.freshman.data.bean.OnlineActivitiesBean
import com.mredrock.cyxbs.freshman.util.apiService
import okhttp3.RequestBody
import org.greenrobot.eventbus.Subscribe
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit


class OnlineCommunicationActivity : BaseViewModelActivity<OnlineCommunicationViewModel>() {
    override val viewModelClass: Class<OnlineCommunicationViewModel> = OnlineCommunicationViewModel::class.java
    override val isFragmentActivity: Boolean = false
    //To change initializer of created properties use File | Settings | File Templates.

    var dialog:AlertDialog? = null
    var view:View? = null

    private var adapter: OnlineCommunicationViewPaggerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_online_communication)
        common_toolbar.init(
            title = "线上交流"
        )
        viewModel.initDialog(this)
        dialog = viewModel.alertDialog
        view = viewModel.view
        adapter = OnlineCommunicationViewPaggerAdapter(this)
        vp_online_communication.adapter = adapter
        tl_online_communication.setupWithViewPager(vp_online_communication)
    }


    override fun onDestroy() {
        super.onDestroy()
        dialog = null
        view = null
        viewModel.dialogDismiss()
    }

    @Subscribe(sticky = true)
    fun upData(groupBean: GroupStudentBean) {
        adapter?.initPager1(groupBean)
    }

    @Subscribe(sticky = true)
    fun upData(groupBean: GroupHomeBean) {
        adapter?.initPager2(groupBean)
    }


    @Subscribe(sticky = true)
    fun upData(bean: OnlineActivitiesBean) {
        adapter?.initPager3(bean)
    }
}
