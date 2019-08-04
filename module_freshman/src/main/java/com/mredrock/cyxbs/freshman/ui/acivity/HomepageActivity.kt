package com.mredrock.cyxbs.freshman.ui.acivity

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.HomepageViewModel


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

}


