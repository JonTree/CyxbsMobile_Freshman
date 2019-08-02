package com.mredrock.cyxbs.freshman.data.ViewModel

import android.util.Log
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.generated.callback.OnClickListener
import org.greenrobot.eventbus.EventBus

class NecessityViewModel :BaseViewModel() {
    init {
        Log.d("MyTag","viewmodel ready")
        EventBus.getDefault().post(1)
    }

}