package com.mredrock.cyxbs.freshman.data.ViewModelCallback

import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideExpressDeliveryBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideManAndWomanBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean

interface CampusGuideViewModelCallback :ViewModelCallback{
    fun onCampusGuideBasicBeanReady(bean:CampusGuideBasicBean?)
    fun onCampusGuideExpressDeliveryBeanReady(bean:CampusGuideExpressDeliveryBean?)
    fun onCampusGuideManAndWomanBeanReady(bean:CampusGuideManAndWomanBean?)
    fun ononCampusGuideSubjectBeanReady(bean:CampusGuideSubjectBean?)
}