package com.mredrock.cyxbs.freshman.data.ViewModel


import com.google.gson.Gson
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideExpressDeliveryBean
import org.greenrobot.eventbus.EventBus

class CampusGuideViewModel :BaseViewModel() {

    val data = "{\n" +
            "  \"code\": 200,\n" +
            "  \"info\": \"ok\",\n" +
            "  \"text\": [\n" +
            "    {\n" +
            "      \"name\": \"顺丰\",\n" +
            "      \"message\": [\n" +
            "        {\n" +
            "        \"title\": \"樱花园\",\n" +
            "          \"detail\": \"顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀顺丰超级好呀\",\n" +
            "          \"photo\":\"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"圆通\",\n" +
            "      \"message\": [\n" +
            "        {\n" +
            "          \"title\": \"樱花园\",\n" +
            "          \"detail\": \"圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀圆通超级好呀\",\n" +
            "             \"photo\":\"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"title\": \"樱花园\",\n" +
            "          \"detail\": \"樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀樱花园超级好呀\",\n" +
            "             \"photo\":\"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2851356855,3283779070&fm=26&gp=0.jpg\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    init {
        val gson = Gson()
        EventBus.getDefault().postSticky(gson.fromJson(data,CampusGuideExpressDeliveryBean::class.java))
    }

    fun sendBean(bean:CampusGuideBean){
        EventBus.getDefault().postSticky(bean)
    }


}