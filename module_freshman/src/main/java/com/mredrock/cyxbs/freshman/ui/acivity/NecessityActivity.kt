package com.mredrock.cyxbs.freshman.ui.acivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.NecessityViewModel
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.event.UpDataMemo
import kotlinx.android.synthetic.main.freshman_activity_necessity.*
import org.greenrobot.eventbus.Subscribe


class NecessityActivity : BaseViewModelActivity<NecessityViewModel>() {
    override val viewModelClass: Class<NecessityViewModel> = NecessityViewModel::class.java
    override val isFragmentActivity: Boolean = false
    //To change initializer of created properties use File | Settings | File Templates.

    lateinit var necessityViewModel:NecessityViewModel


    var isCanClick = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_necessity)
        necessityActivity_back.setOnClickListener {
            finish()
        }



        necessityViewModel = ViewModelProviders.of(this).get(NecessityViewModel::class.java)
        necessityActivity_edit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("memo",necessityViewModel.memo)
            if (isCanClick) {
                startActivity(intent)
                isCanClick = false
            }
        }
        fab.setOnClickListener {
            val intent = Intent(this, NecessitiesMemoActivity::class.java)
            intent.putExtra("memo",necessityViewModel.memo)
            if (isCanClick) {
                startActivity(intent)
                isCanClick = false
            }
        }
        necessityViewModel.getLocal(this)
    }


    override fun onResume() {
        super.onResume()
        necessityViewModel.reComparativeData()
        isCanClick = true
    }

    override fun onStart() {
        super.onStart()
        isCanClick = true
    }


    override fun onPause() {
        super.onPause()
        necessityViewModel.saveData(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        necessityViewModel.internetBean = null
    }


    @Subscribe(sticky = true)
    fun onBeanReady(bean: NecessityBean) {
        necessityViewModel.onBeanReady(bean,res_necessity,this)
    }

    @SuppressLint("CheckResult")
    @Subscribe(sticky = true)
    fun upDataMemo(event: UpDataMemo) {
        necessityViewModel.upDataMemo(event,res_necessity,this)
    }
}
