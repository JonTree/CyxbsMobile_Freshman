package com.mredrock.cyxbs.freshman.data.ViewModelCallback

import com.mredrock.cyxbs.freshman.data.bean.NecessityBean

interface NecessityViewModelCallback :ViewModelCallback{
    fun internetDataReady(bean:NecessityBean)
    fun getLocalData(bean: NecessityBean)
    fun getLocalMemorandum(bean: NecessityBean)
}