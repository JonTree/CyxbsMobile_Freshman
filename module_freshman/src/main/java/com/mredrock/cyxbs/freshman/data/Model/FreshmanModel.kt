package com.mredrock.cyxbs.freshman.data.Model

import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.data.ViewModel.ProcessViewModel
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.*
import com.mredrock.cyxbs.freshman.data.bean.*
import com.mredrock.cyxbs.freshman.util.apiService
import retrofit2.Call
import retrofit2.Response

class FreshmanModel <T:ViewModelCallback>(callback:T) {
    init {
        when{
            callback is NecessityViewModelCallback ->{
            apiService.getNecessityBean().enqueue(object : retrofit2.Callback<NecessityBean>{
                override fun onFailure(call: Call<NecessityBean>, t: Throwable) {
                   callback.onFaire()
                }

                override fun onResponse(call: Call<NecessityBean>, response: Response<NecessityBean>) {
                    callback.onNecessityBeanReady(response.body())
                }
            })
            }

            callback is ProcessViewModelCallback ->{
                apiService.getProcessBean().enqueue(object : retrofit2.Callback<ProcessBean>{
                    override fun onFailure(call: Call<ProcessBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<ProcessBean>, response: Response<ProcessBean>) {
                        callback.onProcessBeanReady(response.body())
                    }
                })
            }

            callback is OnlineCommunicationViewModelCallback ->{
                apiService.getOnlineActivitiesBean().enqueue(object : retrofit2.Callback<OnlineActivitiesBean>{
                    override fun onFailure(call: Call<OnlineActivitiesBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<OnlineActivitiesBean>,
                        response: Response<OnlineActivitiesBean>
                    ) {
                        callback.onOnlineActivitiesBean(response.body())
                    }
                })
            }

            callback is GuidedViewModelCallback ->{
                apiService.getGuideBusBean().enqueue(object : retrofit2.Callback<GuideBusBean>{
                    override fun onFailure(call: Call<GuideBusBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<GuideBusBean>, response: Response<GuideBusBean>) {
                        callback.onGuideBusBeanReady(response.body())
                    }

                })
                apiService.getCampusSightseeingBean().enqueue(object : retrofit2.Callback<CampusSightseeingBean>{
                    override fun onFailure(call: Call<CampusSightseeingBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusSightseeingBean>,
                        response: Response<CampusSightseeingBean>
                    ) {
                        callback.onCampusSightseeingBeanReady(response.body())
                    }
                })
            }

            callback is CampusGuideViewModelCallback ->{
                apiService.getCampusGuideBasicBean().enqueue(object : retrofit2.Callback<CampusGuideBasicBean>{
                    override fun onFailure(call: Call<CampusGuideBasicBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusGuideBasicBean>,
                        response: Response<CampusGuideBasicBean>
                    ) {
                        callback.onCampusGuideBasicBeanReady(response.body())
                    }
                })
                apiService.getCampusGuideExpressDeliveryBean().enqueue(object :retrofit2.Callback<CampusGuideExpressDeliveryBean>{
                    override fun onFailure(call: Call<CampusGuideExpressDeliveryBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusGuideExpressDeliveryBean>,
                        response: Response<CampusGuideExpressDeliveryBean>
                    ) {
                        callback.onCampusGuideExpressDeliveryBeanReady(response.body())
                    }

                })
                apiService.getCampusGuideSubjectBean().enqueue(object : retrofit2.Callback<CampusGuideSubjectBean>{
                    override fun onFailure(call: Call<CampusGuideSubjectBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusGuideSubjectBean>,
                        response: Response<CampusGuideSubjectBean>
                    ) {
                        callback.ononCampusGuideSubjectBeanReady(response.body())
                    }

                })
            }
        }
    }
}