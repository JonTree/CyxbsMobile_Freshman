package com.mredrock.cyxbs.freshman.ui.acivity

import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
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
        val fade = Fade()
        window.enterTransition = fade
        necessityActivity_back.setOnClickListener {
            finish()
        }
        necessityActivity_edit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }


        val viewModel = ViewModelProviders.of(this).get(NecessityViewModel::class.java)
        fab.setOnClickListener {
            val intent = Intent(this, NecessitiesMemoActivity::class.java)
            startActivity(intent)
        }
    }


    @Subscribe(sticky = true)
    fun onBeanReady(bean: NecessityBean) {
        res_necessity.adapter = NecessityAdapter(bean)
        res_necessity.layoutManager = LinearLayoutManager(this)

    }


    @Subscribe
    fun receiveMemo(){

    }

}
