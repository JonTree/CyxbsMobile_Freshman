package com.mredrock.cyxbs.freshman.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mredrock.cyxbs.freshman.R

class HomepageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_home)

        val a = DataBindingUtil.setContentView<com.mredrock.cyxbs.freshman.databinding.FreshmanActivityHomeBinding>(this,R.layout.freshman_activity_home)
        a.addOnPropertyChangedCallback()
        a.

    }


}
