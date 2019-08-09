package com.mredrock.cyxbs.freshman.event

import com.mredrock.cyxbs.freshman.data.bean.CampusSightseeingBean

/**
 * Created by Tree on 2019/8/9 13:43
 */
class SightseeingEvnt {
    var count = 0
    var message1: CampusSightseeingBean.TextBean.MessageBean? = null
        set(value) {
            count++
            field = value
        }
    var message2: CampusSightseeingBean.TextBean.MessageBean? = null
        set(value) {
            count++
            field = value
        }
}
