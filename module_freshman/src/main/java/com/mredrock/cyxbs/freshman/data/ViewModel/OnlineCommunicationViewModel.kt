package com.mredrock.cyxbs.freshman.data.ViewModel

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.View
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.common.viewmodel.event.ProgressDialogEvent
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.Model.FreshmanModel
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.OnlineCommunicationViewModelCallback
import com.mredrock.cyxbs.freshman.data.bean.GroupHomeBean
import com.mredrock.cyxbs.freshman.data.bean.GroupStudentBean
import com.mredrock.cyxbs.freshman.data.bean.OnlineActivitiesBean
import kotlinx.android.synthetic.main.freshman_dailog_item.view.*
import org.greenrobot.eventbus.EventBus

class OnlineCommunicationViewModel :BaseViewModel(){

    lateinit var alertDialog: AlertDialog
    lateinit var view: View

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


    @SuppressLint("ResourceType")
    fun initDialog(context: Context) {
        view = View.inflate(context, R.layout.freshman_dailog_item, null)
        alertDialog = AlertDialog.Builder(context)
            .setView(view).create()
        alertDialog.window.setWindowAnimations(R.anim.freshman_dialog)
        view.apply {
            tv_group_cancle.setOnClickListener { alertDialog.hide() }
        }
    }


    fun dialogDismiss() {
        alertDialog.dismiss()
    }
}