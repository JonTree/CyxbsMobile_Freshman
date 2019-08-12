package com.mredrock.cyxbs.freshman.data.ViewModel

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.common.viewmodel.event.ProgressDialogEvent
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapter.NecessityAdapter
import com.mredrock.cyxbs.freshman.adapter.OnlineActivityRecycleViewAdapter
import com.mredrock.cyxbs.freshman.data.Model.FreshmanModel
import com.mredrock.cyxbs.freshman.data.Model.getObject
import com.mredrock.cyxbs.freshman.data.Model.saveObject
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.NecessityViewModelCallback
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.ProcessViewModelCallback
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.data.bean.ProcessBean
import com.mredrock.cyxbs.freshman.event.UpDataMemo
import com.mredrock.cyxbs.freshman.generated.callback.OnClickListener
import com.mredrock.cyxbs.freshman.util.gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.freshman_activity_necessity.*
import org.greenrobot.eventbus.EventBus

class NecessityViewModel : BaseViewModel() {
    private var basicBean: NecessityBean? = null

    private var localBean: NecessityBean? = null

    lateinit var memo: NecessityBean.TextBean

    lateinit var internetBeanList: List<NecessityBean.TextBean>


    var internetBean: NecessityBean? = null


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

    @SuppressLint("CheckResult")
    fun saveData(context: Context) {
        Observable.create<Any> {
            saveObject(context, "memo", memo)
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {}
        Observable.create<Any> {
            internetBean?.let { it1 -> saveObject(context, "internetBean", it1) }
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {}
    }


    @SuppressLint("CheckResult")
    fun getLocal(context: Context) {
        Observable.create<Any> {
            if (getObject(context, "memo") == null) {
                memo = NecessityBean.TextBean()
                memo.title = "备忘录"
                memo.data = mutableListOf<NecessityBean.TextBean.DataBean>()
            } else {
                memo = getObject(context, "memo") as NecessityBean.TextBean
            }
        }.subscribeOn(Schedulers.io()).subscribe {}
        Observable.create<Any> {
            localBean = getObject(context, "internetBean") as? NecessityBean?
        }.subscribeOn(Schedulers.io()).subscribe {}
    }

    @SuppressLint("CheckResult")
    fun upDataMemo(event: UpDataMemo, recycleView: RecyclerView, context: Context) {
        if (event.memo.data.size != 0 || event.isEdit) {
            internetBean?.text = listOf(event.memo) + internetBeanList
            if (internetBean?.text?.get(0)?.title ?: "备忘录" == "备忘录" && internetBean?.text?.get(0)?.data?.size ?: 0 == 0) {
                internetBean?.text?.removeAt(0)
            }
            memo = event.memo
            Observable.create<Any> {
                saveObject(context, "memo", memo)
            }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {}
            recycleView.adapter?.notifyDataSetChanged()
        }
    }

    @SuppressLint("CheckResult")
    fun onBeanReady(bean: NecessityBean, recycleView: RecyclerView, context: Context) {
        if (bean.text[0].title == "备忘录") {
            bean.text.removeAt(0)
        }
        internetBean = bean
        Observable.create<Any> {
            if (internetBean != null && localBean != null) {
                comparativeData(internetBean!!, localBean!!)
            }
        }.subscribeOn(Schedulers.io()).subscribe {}
        internetBeanList = bean.text
        if (memo.data.size != 0) {
            internetBean?.text = mutableListOf(memo) + internetBeanList
        }
        val adapter = NecessityAdapter(internetBean!!)
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(context)
    }


    fun reComparativeData() {
        comparativeData(internetBean,localBean)
    }


    private fun comparativeData(internetBean: NecessityBean?, localBean: NecessityBean?) {
        if (internetBean != null && localBean != null) {
            internetBean.text.forEach {
                it.data.forEach { internet ->
                    localBean.text.forEach {
                        it.data.forEach { local ->
                            if (internet.name == local.name) {
                                internet.prepared = local.prepared
                            }
                        }
                    }
                }
            }
        }
    }
}