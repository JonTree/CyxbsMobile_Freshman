package com.mredrock.cyxbs.freshman.updata

import com.mredrock.cyxbs.freshman.data.bean.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import okhttp3.RequestBody
import com.google.gson.JsonObject




/**
 * Created by Tree on 2019/8/8 15:32
 */
const val DATA_BASE_URI = "http://129.28.185.138:9025/"
const val IMAGE_BASE_URI = "${DATA_BASE_URI}zsqy/image/"

interface APIService {


    @GET("zsqy/json/1")
    fun getNecessityBean(): Call<NecessityBean>

    @GET("zsqy/json/2")
    fun getProcessBean(): Call<ProcessBean>

    @GET("zsqy/json/4")
    fun getCampusGuideSubjectBean(): Call<CampusGuideSubjectBean>

    @GET("zsqy/json/44")
    fun getCampusGuideManAndWomanBean(): Call<CampusGuideManAndWomanBean>

    @GET("zsqy/json/3")
    fun getCampusGuideBasicBean(): Call<CampusGuideBasicBean>

    @GET("zsqy/json/33")
    fun getCampusGuideExpressDeliveryBean(): Call<CampusGuideExpressDeliveryBean>

    @GET("zsqy/json/5")
    fun getGuideBusBean():Call<GuideBusBean>

    @GET("zsqy/json/6")
    fun getCampusSightseeingBean(): Call<CampusSightseeingBean>

    @GET("zsqy/json/77")
    fun getGroupHometownBean(): Call<GroupHomeBean>


    @GET("zsqy/json/9")
    fun getOnlineActivitiesBean():Call<OnlineActivitiesBean>


    @GET("zsqy/json/7")
    fun getGroupStudentBean():Call<GroupStudentBean>

    @Multipart
    @POST("zsqy/select/college")
    fun getGroupCollegeSearch(@Part("college") college: RequestBody): Call<GroupStudentBean>

    @Multipart
    @POST("zsqy/select/province")
    fun getGroupProvinceSearch(@Part("province") college: RequestBody): Call<GroupStudentBean>


}


