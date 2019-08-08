package com.mredrock.cyxbs.freshman.data.ViewModelCallback

import com.mredrock.cyxbs.freshman.data.bean.CampusSightseeingBean
import com.mredrock.cyxbs.freshman.data.bean.GuideBusBean

interface GuidedViewModelCallback {
    fun onGuideBusBeanReady(bean:GuideBusBean?)
    fun onCampusSightseeingBeanReady(bean:CampusSightseeingBean?)
}