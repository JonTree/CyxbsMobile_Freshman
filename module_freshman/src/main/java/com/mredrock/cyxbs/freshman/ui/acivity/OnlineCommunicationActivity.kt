package com.mredrock.cyxbs.freshman.ui.acivity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.OnlineCommunicationViewModel
import kotlinx.android.synthetic.main.freshman_activity_online_communication.*
import org.jetbrains.anko.Android
import android.transition.Slide
import android.view.View
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.data.Model.FreshmanModel
import com.mredrock.cyxbs.freshman.data.ViewModel.NecessityViewModel
import com.mredrock.cyxbs.freshman.updata.APIService
import com.mredrock.cyxbs.freshman.updata.ApiGenerator
import org.jetbrains.anko.sdk27.coroutines.onClick


class OnlineCommunicationActivity : BaseViewModelActivity<OnlineCommunicationViewModel>() {
    override val viewModelClass: Class<OnlineCommunicationViewModel> = OnlineCommunicationViewModel::class.java
    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_online_communication)
//        val slide = Slide()

//        FreshmanModel<NecessityViewModel>(NecessityViewModel())
        LogUtils.d("MyTag","Onclick0")

//        btn_test.setOnClickListener {View.OnClickListener(){
//
//        }
//        }
    }

    override fun onResume() {
        super.onResume()



    }
}
