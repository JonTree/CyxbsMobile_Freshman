package com.mredrock.cyxbs.freshman.data.ViewModelCallback

import com.mredrock.cyxbs.freshman.data.bean.NecessityBean

interface NecessityViewModelCallback :ViewModelCallback{
    fun onNecessityBeanReady(bean:NecessityBean?)
}