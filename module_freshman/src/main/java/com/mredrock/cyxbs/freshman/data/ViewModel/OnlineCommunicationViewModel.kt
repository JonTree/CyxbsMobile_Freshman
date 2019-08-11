package com.mredrock.cyxbs.freshman.data.ViewModel

import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.common.viewmodel.event.ProgressDialogEvent
import com.mredrock.cyxbs.freshman.data.Model.FreshmanModel
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.OnlineCommunicationViewModelCallback
import com.mredrock.cyxbs.freshman.data.bean.GroupHomeBean
import com.mredrock.cyxbs.freshman.data.bean.GroupStudentBean
import com.mredrock.cyxbs.freshman.data.bean.OnlineActivitiesBean
import org.greenrobot.eventbus.EventBus

class OnlineCommunicationViewModel :BaseViewModel(){
    private val freshmanModel: FreshmanModel<OnlineCommunicationViewModelCallback> = FreshmanModel(object :
        OnlineCommunicationViewModelCallback{
        override fun onOnlineStudentBean(bean: GroupStudentBean?) {
            EventBus.getDefault().postSticky(bean)
            progressDialogEvent.value =
                ProgressDialogEvent.DISMISS_DIALOG_EVENT

        }

        override fun onOnlineHomeBean(bean: GroupHomeBean?) {
            EventBus.getDefault().postSticky(bean)
            progressDialogEvent.value =
                ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }

        override fun onOnlineActivitiesBean(bean: OnlineActivitiesBean?) {
            EventBus.getDefault().postSticky(bean)
            progressDialogEvent.value =
                ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }

        override fun onFaire() {

        }
    })
    init {
        progressDialogEvent.value =
            ProgressDialogEvent.SHOW_CANCELABLE_DIALOG_EVENT
    }
}