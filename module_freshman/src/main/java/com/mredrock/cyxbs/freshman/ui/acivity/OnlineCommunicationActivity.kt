package com.mredrock.cyxbs.freshman.ui.acivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import com.maning.imagebrowserlibrary.MNImageBrowser
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.OnlineCommunicationViewModel
import com.mredrock.cyxbs.freshman.util.MyImageEngine
import kotlinx.android.synthetic.main.freshman_activity_online_communication.*
import org.jetbrains.anko.Android
import android.transition.Slide


class OnlineCommunicationActivity : BaseViewModelActivity<OnlineCommunicationViewModel>() {
    override val viewModelClass: Class<OnlineCommunicationViewModel> = OnlineCommunicationViewModel::class.java
    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_online_communication)

        val slide = Slide()
        slide.setDuration(1000)
        window.exitTransition = slide

        cv_.setManProportion(0.9f)
        MNImageBrowser.with(this)
            .setCustomShadeView(View.inflate(this,R.layout.freshman_custom_view,null))
            .setIndicatorHide(true)
            .setImageEngine(MyImageEngine())
            .setImageUrl("https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg")
            .setFullScreenMode(true)
            .show(cv_)


//        val  title = listOf<String>("gs","dw","ls")
//        fs_aaaa.data = dataa
//        fs_aaaa.title= title
    }
}
