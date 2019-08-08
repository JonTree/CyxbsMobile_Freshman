package com.mredrock.cyxbs.freshman.data.ViewModelCallback

import com.mredrock.cyxbs.freshman.data.bean.ProcessBean

interface ProcessViewModelCallback {
    fun onProcessBeanReady(bean:ProcessBean?)
}