package com.mredrock.cyxbs.freshman.ui.acivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.HomepageViewModel
import kotlinx.android.synthetic.main.freshman_activity_home.*


class HomepageActivity : BaseViewModelActivity<HomepageViewModel>() {
    override val viewModelClass: Class<HomepageViewModel> = HomepageViewModel::class.java

    override val isFragmentActivity: Boolean = false
         //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.freshman_activity_home)

        val binding = DataBindingUtil.setContentView<com.mredrock.cyxbs.freshman.databinding.FreshmanActivityHomeBinding>(this,R.layout.freshman_activity_home)
        binding.lifecycleOwner = this
        val homepageViewModel = ViewModelProviders.of(this).get(HomepageViewModel::class.java)
        binding.activity = this

    }

    override fun onResume() {
        initAnimation()
        super.onResume()
    }

    private fun initAnimation (){
//        val animation :RotateAnimation = RotateAnimation(0f,359f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
//        animation.repeatMode = Animation.RESTART
//        animation.repeatCount = Animation.INFINITE
//        animation.duration = 4000
//        animation.interpolator = AccelerateInterpolator()
////        animation.fillAfter = true
        val animation = AnimationUtils.loadAnimation(this, com.mredrock.cyxbs.freshman.R.anim.freshman_rotate_screw)
        val animationRed = AnimationUtils.loadAnimation(this,R.anim.freshman_rotate_screw_red)
        animation.repeatMode = Animation.RESTART
        animation.repeatCount = Animation.INFINITE
        animation.interpolator = LinearInterpolator()
        animationRed.repeatMode = Animation.RESTART
        animationRed.repeatCount = Animation.INFINITE

        animationRed.interpolator = LinearInterpolator()
        iv_home_purple_screw.startAnimation(animation)


//        LogUtils.d("MyTag","${iv_home_red_screw.layoutParams.height}")
//        val animationRed :RotateAnimation = RotateAnimation(0f,350f,Animation.RELATIVE_TO_SELF,-iv_home_red_screw.layoutParams.height/2f,Animation.RELATIVE_TO_SELF,-iv_home_red_screw.layoutParams.height/2f)
//        animationRed.repeatMode = Animation.RESTART
//        animationRed.repeatCount = Animation.INFINITE
//        animationRed.interpolator = AccelerateInterpolator()
//        animationRed.duration = 4000
//        animationRed.fillAfter = true
        iv_home_red_screw.startAnimation(animationRed)
    }

    fun onClick(index:Int){
        val intent:Intent
        when(index){
            1 ->startActivity<NecessityActivity>()

            2 ->startActivity<GuideActivity>()

            3 ->startActivity<ProcessActivity>()

            4 ->startActivity<CampusGuideActivity>()

            5 -> startActivity<OnlineCommunicationActivity>()

            6 -> startActivity<MoreFunctionActivity>()

//            7 -> startActivity<>()
        }

    }

    override fun onStop() {
        iv_home_red_screw.clearAnimation()
        iv_home_purple_screw.clearAnimation()
        super.onStop()
    }
}


