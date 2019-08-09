package com.mredrock.cyxbs.freshman.event

import com.mredrock.cyxbs.freshman.data.bean.CampusSightseeingBean
import com.mredrock.cyxbs.freshman.data.bean.GuideBusBean

/**
 * Created by Tree on 2019/8/9 0:16
 */
data class GuideDataEvent(val guideBusBean: GuideBusBean,val campusSightseeingBean: CampusSightseeingBean)