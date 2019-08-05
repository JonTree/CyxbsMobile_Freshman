package com.mredrock.cyxbs.freshman.data.ViewModel


import com.google.gson.Gson
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideExpressDeliveryBean
import org.greenrobot.eventbus.EventBus

class CampusGuideViewModel :BaseViewModel() {

    val data = "{\n" +
            "  \"code\": 200,\n" +
            "  \"info\": \"ok\",\n" +
            "  \"text\": [\n" +
            "    {\n" +
            "      \"title\": \"宿舍\",\n" +
            "      \"message\": [\n" +
            "        {\n" +
            "          \"name\": \"明理苑\",\n" +
            "          \"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\",\n" +
            "          \"photos\": [\n" +
            "            \"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\",\n" +
            "            \"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\"\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"宁静苑\",\n" +
            "          \"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\",\n" +
            "          \"photos\": [\n" +
            "              \"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\",\n" +
            "            \"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\"\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"宁静苑\",\n" +
            "          \"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\",\n" +
            "          \"photos\": [\n" +
            "                \"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\",\n" +
            "            \"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\"\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"宁静苑\",\n" +
            "          \"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\",\n" +
            "          \"photos\": [\n" +
            "            \"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\",\n" +
            "            \"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\"\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"食堂\",\n" +
            "      \"message\": [\n" +
            "        {\n" +
            "          \"name\": \"红高粱\",\n" +
            "          \"detail\": \"....\",\n" +
            "          \"photos\": [\n" +
            "            \"...\",\n" +
            "            \"...\"\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"中心食堂\",\n" +
            "          \"detail\": \"....\",\n" +
            "          \"photos\": [\n" +
            "            \"...\",\n" +
            "            \"...\"\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    init {
        val gson = Gson()
        EventBus.getDefault().postSticky(gson.fromJson(data,CampusGuideBasicBean::class.java))
    }

    fun sendBean(bean:CampusGuideBean){
        EventBus.getDefault().postSticky(bean)
    }


}