package com.mredrock.cyxbs.freshman.data.ViewModel


import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideDemystifyBean
import com.mredrock.cyxbs.freshman.util.gson
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


    val de = "{\n" +
            "\t\"code\": 200,\n" +
            "\t\"info\": \"ok\",\n" +
            "\t\"text\": [{\n" +
            "\t\t\t\"name\": \"学院\",\n" +
            "\t\t\t\"message\": [{\n" +
            "\t\t\t\t\t\"title\": \"最难科目\",\n" +
            "\t\t\t\t\t\"data\": [{\n" +
            "\t\t\t\t\t\t\"subject\": \"数学\",\n" +
            "\t\t\t\t\t\t\"data\": \"80%\"\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"subject\": \"物理\",\n" +
            "\t\t\t\t\t\t\"data\": \"80%\"\n" +
            "\t\t\t\t\t}]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"title\": \"男女比例\",\n" +
            "\t\t\t\t\t\"boy\": \"20%\",\n" +
            "\t\t\t\t\t\"girl\": \"80%\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"name\": \"学院\",\n" +
            "\t\t\t\"message\": [{\n" +
            "\t\t\t\t\t\"title\": \"最难科目\",\n" +
            "\t\t\t\t\t\"data\": [{\n" +
            "\t\t\t\t\t\t\"subject\": \"数学\",\n" +
            "\t\t\t\t\t\t\"data\": \"80%\"\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"subject\": \"物理\",\n" +
            "\t\t\t\t\t\t\"data\": \"80%\"\n" +
            "\t\t\t\t\t}]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"title\": \"男女比例\",\n" +
            "\t\t\t\t\t\"boy\": \"20%\",\n" +
            "\t\t\t\t\t\"girl\": \"80%\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}"

    init {
        val a = gson.fromJson(data, CampusGuideBasicBean::class.java)

        EventBus.getDefault().postSticky(a)
        EventBus.getDefault().postSticky(gson.fromJson(de,CampusGuideDemystifyBean::class.java))
    }

    fun sendBean(bean: CampusGuideSubjectBean){
        EventBus.getDefault().postSticky(bean)
    }


}