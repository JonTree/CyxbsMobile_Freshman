package com.mredrock.cyxbs.freshman.data.ViewModelCallback

import com.mredrock.cyxbs.freshman.data.bean.GroupHomeBean
import com.mredrock.cyxbs.freshman.data.bean.GroupStudentBean
import com.mredrock.cyxbs.freshman.data.bean.OnlineActivitiesBean

interface OnlineCommunicationViewModelCallback :ViewModelCallback{
    fun onOnlineActivitiesBean(bean:OnlineActivitiesBean?)
    fun onOnlineStudentBean(bean: GroupStudentBean?)
    fun onOnlineHomeBean(bean: GroupHomeBean?)
}