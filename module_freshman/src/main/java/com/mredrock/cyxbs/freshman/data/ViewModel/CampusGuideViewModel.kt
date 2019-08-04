package com.mredrock.cyxbs.freshman.data.ViewModel


import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBean
import org.greenrobot.eventbus.EventBus

class CampusGuideViewModel :BaseViewModel() {
    fun sendBean(bean:CampusGuideBean){
        EventBus.getDefault().postSticky(bean)
    }


}