package com.mredrock.cyxbs.freshman.ui.acivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.OnlineCommunicationViewModel
import kotlinx.android.synthetic.main.freshman_activity_online_communication.*
import org.jetbrains.anko.Android
import android.transition.Slide
import com.mredrock.cyxbs.freshman.updata.APIService
import com.mredrock.cyxbs.freshman.updata.ApiGenerator


class OnlineCommunicationActivity : BaseViewModelActivity<OnlineCommunicationViewModel>() {
    override val viewModelClass: Class<OnlineCommunicationViewModel> = OnlineCommunicationViewModel::class.java
    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_online_communication)
    }
}
