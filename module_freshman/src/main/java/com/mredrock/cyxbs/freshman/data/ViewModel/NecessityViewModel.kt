package com.mredrock.cyxbs.freshman.data.ViewModel

import android.util.Log
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.generated.callback.OnClickListener
import com.mredrock.cyxbs.freshman.util.gson
import org.greenrobot.eventbus.EventBus

class NecessityViewModel :BaseViewModel() {

    val data = "{\n" +
            "\t\"code\": 200,\n" +
            "\t\"info\": \"ok\",\n" +
            "\t\"text\": [{\n" +
            "\t\t\t\"title\": \"报道必备\",\n" +
            "\t\t\t\"data\": [{\n" +
            "\t\t\t\t\t\"name\": \"录取通知书\",\n" +
            "\t\t\t\t\t\"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"高考准考证\",\n" +
            "\t\t\t\t\t\"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\": \"军训必备\",\n" +
            "\t\t\t\"data\": [{\n" +
            "\t\t\t\t\t\"name\": \"花露水\",\n" +
            "\t\t\t\t\t\"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"防暑药\",\n" +
            "\t\t\t\t\t\"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"title\": \"*以下为非必需\",\n" +
            "\t\t\t\"data\": [{\n" +
            "\t\t\t\t\t\"name\": \"*学籍档案\",\n" +
            "\t\t\t\t\t\"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"*本人户口本内页\",\n" +
            "\t\t\t\t\t\"detail\": \"啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}"

    init {
        EventBus.getDefault().postSticky(gson.fromJson(data, NecessityBean::class.java))
    }


}