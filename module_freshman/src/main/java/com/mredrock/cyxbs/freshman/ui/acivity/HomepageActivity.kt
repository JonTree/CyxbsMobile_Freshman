package com.mredrock.cyxbs.freshman.ui.acivity

import android.Manifest
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.utils.extensions.doPermissionAction
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.Model.getLetterViewState
import com.mredrock.cyxbs.freshman.data.Model.letterViewShowed
import com.mredrock.cyxbs.freshman.data.ViewModel.HomepageViewModel
import com.mredrock.cyxbs.freshman.ui.view.FreshmanLetterView
import kotlinx.android.synthetic.main.freshman_activity_home.*


class HomepageActivity : BaseViewModelActivity<HomepageViewModel>() {
    override val viewModelClass: Class<HomepageViewModel> = HomepageViewModel::class.java

    override val isFragmentActivity: Boolean = false
    //To change initializer of created properties use File | Settings | File Templates.


    var isCanClick = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<com.mredrock.cyxbs.freshman.databinding.FreshmanActivityHomeBinding>(
                this,
                R.layout.freshman_activity_home
            )

        binding.lifecycleOwner = this
        val homepageViewModel = ViewModelProviders.of(this).get(HomepageViewModel::class.java)
        binding.activity = this
        fl_letter.setOnTouchListener { v, event -> true }
        ll_home_i_know.setOnClickListener {
            fl_letter.visibility = View.GONE
            letterViewShowed(this)
        }

        flv_home.setOnAnimationDoneListener(object : FreshmanLetterView.AnimationDoneListener {
            override fun onAnimationDone() {
                ll_text_part.visibility = View.VISIBLE
            }

        })
        /*
        初次进入是否执行
         */
//        if(!getLetterViewState(this))
        ll_worlds.visibility = View.VISIBLE

    }

    override fun onResume() {
        initAnimation()
        super.onResume()
        isCanClick = true
    }


    override fun onStart() {
        super.onStart()
        isCanClick = true
    }

    private fun initAnimation() {
//        val animation :RotateAnimation = RotateAnimation(0f,359f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
//        animation.repeatMode = Animation.RESTART
//        animation.repeatCount = Animation.INFINITE
//        animation.duration = 4000
//        animation.interpolator = AccelerateInterpolator()
////        animation.fillAfter = true
        val animation = AnimationUtils.loadAnimation(this, com.mredrock.cyxbs.freshman.R.anim.freshman_rotate_screw)
        val animationRed = AnimationUtils.loadAnimation(this, R.anim.freshman_rotate_screw_red)
        animation.repeatMode = Animation.RESTART
        animation.repeatCount = Animation.INFINITE
        animation.interpolator = LinearInterpolator() as Interpolator?
        animationRed.repeatMode = Animation.RESTART
        animationRed.repeatCount = Animation.INFINITE

        animationRed.interpolator = LinearInterpolator()


//        LogUtils.d("MyTag","${iv_home_red_screw.layoutParams.height}")
//        val animationRed :RotateAnimation = RotateAnimation(0f,350f,Animation.RELATIVE_TO_SELF,-iv_home_red_screw.layoutParams.height/2f,Animation.RELATIVE_TO_SELF,-iv_home_red_screw.layoutParams.height/2f)
//        animationRed.repeatMode = Animation.RESTART
//        animationRed.repeatCount = Animation.INFINITE
//        animationRed.interpolator = AccelerateInterpolator()
//        animationRed.duration = 4000
//        animationRed.fillAfter = true
        iv_home_red_screw.startAnimation(animationRed)
    }

    fun onClick(index: Int) {
        val intent: Intent
        if (isCanClick) {

            when (index) {
                1 -> {
                        val intent = Intent(this, NecessityActivity::class.java)
                        startActivity(intent)
                }

                2 -> {
                    val intent = Intent(this, GuideActivity::class.java)
                    startActivity(intent)
                }

                3 -> {

                    val intent = Intent(this, ProcessActivity::class.java)
                    startActivity(intent)
                }

                4 -> {

                    val intent = Intent(this, CampusGuideActivity::class.java)
                    startActivity(intent)
                }

                5 -> {

                    val intent = Intent(this, OnlineCommunicationActivity::class.java)
                    startActivity(intent)
                }

                6 -> {

                    val intent = Intent(this, MoreFunctionActivity::class.java)
                    startActivity(intent)
                }

//            7 -> startActivity<>()
            }
            isCanClick = false

        }


    }

    override fun onPause() {
        iv_home_red_screw.clearAnimation()
        super.onPause()
    }

    override fun onStop() {

        super.onStop()
    }
}


