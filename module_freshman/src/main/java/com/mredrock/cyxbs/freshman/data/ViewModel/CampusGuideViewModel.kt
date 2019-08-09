package com.mredrock.cyxbs.freshman.data.ViewModel


import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.common.viewmodel.event.ProgressDialogEvent
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.Model.FreshmanModel
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.CampusGuideViewModelCallback
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.NecessityViewModelCallback
import com.mredrock.cyxbs.freshman.data.bean.*
import com.mredrock.cyxbs.freshman.util.gson
import org.greenrobot.eventbus.EventBus

class CampusGuideViewModel :BaseViewModel() {
    private val freshmanModel: FreshmanModel<CampusGuideViewModelCallback> = FreshmanModel(object :
        CampusGuideViewModelCallback {
        override fun onCampusGuideBasicBeanReady(bean: CampusGuideBasicBean?) {
            EventBus.getDefault().postSticky(bean)
            progressDialogEvent.value = ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }

        override fun onCampusGuideExpressDeliveryBeanReady(bean: CampusGuideExpressDeliveryBean?) {
            EventBus.getDefault().postSticky(bean)
            progressDialogEvent.value = ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }

        override fun onCampusGuideManAndWomanBeanReady(bean: CampusGuideManAndWomanBean?) {
            EventBus.getDefault().postSticky(bean)
            progressDialogEvent.value = ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }

        override fun ononCampusGuideSubjectBeanReady(bean: CampusGuideSubjectBean?) {
            EventBus.getDefault().postSticky(bean)
            progressDialogEvent.value = ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }

        override fun onFaire() {
            toastEvent.value = R.string.freshman_data_error
            progressDialogEvent.value = ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }

    })
    init {
        progressDialogEvent.value = ProgressDialogEvent.SHOW_CANCELABLE_DIALOG_EVENT
    }
}