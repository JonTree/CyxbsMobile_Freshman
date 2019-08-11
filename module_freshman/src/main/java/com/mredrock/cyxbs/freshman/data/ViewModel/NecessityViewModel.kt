package com.mredrock.cyxbs.freshman.data.ViewModel

import android.util.Log
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.common.viewmodel.event.ProgressDialogEvent
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.Model.FreshmanModel
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.NecessityViewModelCallback
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.ProcessViewModelCallback
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.data.bean.ProcessBean
import com.mredrock.cyxbs.freshman.generated.callback.OnClickListener
import com.mredrock.cyxbs.freshman.util.gson
import org.greenrobot.eventbus.EventBus

class NecessityViewModel :BaseViewModel() {
    private var basicBean :NecessityBean? = null
    private var localBean :NecessityBean? = null

    private val freshmanModel: FreshmanModel<NecessityViewModelCallback> = FreshmanModel(object :
        NecessityViewModelCallback {
        override fun onBeanReaded(bean: NecessityBean) {
            localBean = bean
        }

        override fun onNecessityBeanReady(bean: NecessityBean?) {
            basicBean = bean
            EventBus.getDefault().postSticky(bean)
            progressDialogEvent.value = ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }


        override fun onFaire() {
            toastEvent.value = R.string.freshman_data_error
            progressDialogEvent.value = ProgressDialogEvent.DISMISS_DIALOG_EVENT
        }

    })
    init {
        progressDialogEvent.value =
            ProgressDialogEvent.SHOW_CANCELABLE_DIALOG_EVENT

    }







}