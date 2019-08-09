package com.mredrock.cyxbs.freshman.data.ViewModelCallback

import com.mredrock.cyxbs.freshman.data.bean.OnlineActivitiesBean

interface OnlineCommunicationViewModelCallback :ViewModelCallback{
    fun onOnlineActivitiesBean(bean:OnlineActivitiesBean?)
}