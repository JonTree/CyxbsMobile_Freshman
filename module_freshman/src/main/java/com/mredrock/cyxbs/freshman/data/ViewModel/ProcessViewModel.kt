package com.mredrock.cyxbs.freshman.data.ViewModel

import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.data.Model.FreshmanModel
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.ProcessViewModelCallback
import com.mredrock.cyxbs.freshman.data.bean.ProcessBean
import org.greenrobot.eventbus.EventBus

class ProcessViewModel :BaseViewModel() {
    private val freshmanModel:FreshmanModel<ProcessViewModelCallback> = FreshmanModel(object :ProcessViewModelCallback{
        override fun onProcessBeanReady(bean: ProcessBean?) {
            EventBus.getDefault().postSticky(bean)
        }

        override fun onFaire() {
        }

    })
}