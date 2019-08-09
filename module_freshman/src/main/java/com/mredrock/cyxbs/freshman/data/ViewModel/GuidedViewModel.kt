package com.mredrock.cyxbs.freshman.data.ViewModel

import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.common.viewmodel.event.ProgressDialogEvent
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.Model.FreshmanModel
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.GuidedViewModelCallback
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.NecessityViewModelCallback
import com.mredrock.cyxbs.freshman.data.bean.CampusSightseeingBean
import com.mredrock.cyxbs.freshman.data.bean.GuideBusBean
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.event.GuideDataEvent
import org.greenrobot.eventbus.EventBus

class GuidedViewModel :BaseViewModel() {


    var busBean :GuideBusBean? = null
    var sightseeingBean :CampusSightseeingBean? = null
    private val freshmanModel: FreshmanModel<GuidedViewModelCallback> = FreshmanModel(object :
        GuidedViewModelCallback {
        override fun onGuideBusBeanReady(bean: GuideBusBean?) {
            busBean = bean
            sendData()
        }

        override fun onCampusSightseeingBeanReady(bean: CampusSightseeingBean?) {
            sightseeingBean = bean
            sendData()
        }


        override fun onFaire() {
            toastEvent.value = R.string.freshman_data_error
            progressDialogEvent.value = ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }

    })
    init {
        progressDialogEvent.value = ProgressDialogEvent.SHOW_CANCELABLE_DIALOG_EVENT
    }

    fun sendData(){
        if(busBean != null && sightseeingBean != null){
            EventBus.getDefault().postSticky(GuideDataEvent(busBean!!,sightseeingBean!!))
            progressDialogEvent.value = ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }
    }
}