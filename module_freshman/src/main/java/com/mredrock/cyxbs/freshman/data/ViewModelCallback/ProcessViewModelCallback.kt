package com.mredrock.cyxbs.freshman.data.ViewModelCallback

import com.mredrock.cyxbs.freshman.data.bean.ProcessBean

interface ProcessViewModelCallback :ViewModelCallback{
    fun onProcessBeanReady(bean:ProcessBean?)
}