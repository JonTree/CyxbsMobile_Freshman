package com.mredrock.cyxbs.freshman.event

import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean
import com.mredrock.cyxbs.freshman.data.bean.GuideBusBean

/**
 * Created by Tree on 2019/8/9 0:10
 */
data class CampusGuideDataEvent( val guideBusBean: GuideBusBean,val subjectBean: CampusGuideSubjectBean)