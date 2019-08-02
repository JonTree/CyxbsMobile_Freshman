package com.mredrock.cyxbs.freshman.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.HomepageViewModel
import com.mredrock.cyxbs.freshman.util.util.kt

class HomepageActivity : BaseActivity() {
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
            1 ->{
                this.startActivity<NecessityActivity>()
            }
            2 ->{
                this.startActivity<GuidedActivity>()
            }
            3 ->{
                this.startActivity<ProcessActivity>()
            }
            4 ->{
                this.startActivity<>()
            }
        }

    }

}


