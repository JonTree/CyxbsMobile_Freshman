package com.mredrock.cyxbs.freshman.data.Model

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.provider.Settings
import com.mredrock.cyxbs.common.utils.extensions.defaultSharedPreferences
import com.mredrock.cyxbs.common.utils.extensions.editor
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.*
import com.mredrock.cyxbs.freshman.data.bean.*
import com.mredrock.cyxbs.freshman.util.apiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Response
import java.io.*
import android.content.Context.MODE_PRIVATE
import android.net.Uri
import android.os.Environment.DIRECTORY_PICTURES


fun letterViewShowed(context:Context){
    context.defaultSharedPreferences.editor {
        putBoolean("letterViewShowed",true)
    }
}

fun getLetterViewState(context: Context):Boolean{
    return context.defaultSharedPreferences.getBoolean("letterViewShowed",false)
}
@SuppressLint("CheckResult")
fun saveBitmap(bitmap:Bitmap, name:String,context:Context){
    Observable.create<Any> {

        val file = Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES)
        val saveFile = File(file, "$name.jpg")
        if(!saveFile.exists()){
            saveFile.createNewFile()
        }
        val outputStream = FileOutputStream(saveFile)
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream)
        outputStream.flush()
        outputStream.close()
        val contentUri = Uri.fromFile(saveFile)
        val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,contentUri)
        context.sendBroadcast(mediaScanIntent)

    }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { }

}


class FreshmanModel<T : ViewModelCallback>(callback: T) {
    init {
        when {
            callback is NecessityViewModelCallback -> {
                apiService.getNecessityBean().enqueue(object : retrofit2.Callback<NecessityBean> {
                    override fun onFailure(call: Call<NecessityBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<NecessityBean>, response: Response<NecessityBean>) {
                        if (response.code() == 200)
                            callback.onNecessityBeanReady(response.body())
                        else
                            callback.onFaire()
                    }
                })
            }



            callback is ProcessViewModelCallback -> {
                apiService.getProcessBean().enqueue(object : retrofit2.Callback<ProcessBean> {
                    override fun onFailure(call: Call<ProcessBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<ProcessBean>, response: Response<ProcessBean>) {
                        if (response.code() == 200)
                            callback.onProcessBeanReady(response.body())
                        else
                            callback.onFaire()

                    }
                })
            }

            callback is OnlineCommunicationViewModelCallback -> {
                apiService.getOnlineActivitiesBean().enqueue(object : retrofit2.Callback<OnlineActivitiesBean> {
                    override fun onFailure(call: Call<OnlineActivitiesBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<OnlineActivitiesBean>,
                        response: Response<OnlineActivitiesBean>
                    ) {
                        if (response.code() == 200)
                            callback.onOnlineActivitiesBean(response.body())
                        else
                            callback.onFaire()

                    }
                })
                apiService.getGroupHometownBean().enqueue(object : retrofit2.Callback<GroupHomeBean> {
                    override fun onFailure(call: Call<GroupHomeBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<GroupHomeBean>, response: Response<GroupHomeBean>) {
                        if (response.code() == 200)
                            callback.onOnlineHomeBean(response.body())
                        else
                            callback.onFaire()
                    }
                })
                apiService.getGroupStudentBean().enqueue(object : retrofit2.Callback<GroupStudentBean> {
                    override fun onFailure(call: Call<GroupStudentBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<GroupStudentBean>, response: Response<GroupStudentBean>) {
                        if (response.code() == 200)
                            callback.onOnlineStudentBean(response.body())
                        else
                            callback.onFaire()
                    }
                })

            }

            callback is GuidedViewModelCallback -> {
                apiService.getGuideBusBean().enqueue(object : retrofit2.Callback<GuideBusBean> {
                    override fun onFailure(call: Call<GuideBusBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<GuideBusBean>, response: Response<GuideBusBean>) {
                        if (response.code() == 200)
                            callback.onGuideBusBeanReady(response.body())
                        else
                            callback.onFaire()

                    }

                })
                apiService.getCampusSightseeingBean().enqueue(object : retrofit2.Callback<CampusSightseeingBean> {
                    override fun onFailure(call: Call<CampusSightseeingBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusSightseeingBean>,
                        response: Response<CampusSightseeingBean>
                    ) {
                        if (response.code() == 200)
                            callback.onCampusSightseeingBeanReady(response.body())
                        else
                            callback.onFaire()

                    }
                })
            }

            callback is CampusGuideViewModelCallback -> {
                apiService.getCampusGuideBasicBean().enqueue(object : retrofit2.Callback<CampusGuideBasicBean> {
                    override fun onFailure(call: Call<CampusGuideBasicBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusGuideBasicBean>,
                        response: Response<CampusGuideBasicBean>
                    ) {
                        if (response.code() == 200)
                            callback.onCampusGuideBasicBeanReady(response.body())
                        else
                            callback.onFaire()

                    }
                })
                apiService.getCampusGuideExpressDeliveryBean()
                    .enqueue(object : retrofit2.Callback<CampusGuideExpressDeliveryBean> {
                        override fun onFailure(call: Call<CampusGuideExpressDeliveryBean>, t: Throwable) {
                            callback.onFaire()
                        }

                        override fun onResponse(
                            call: Call<CampusGuideExpressDeliveryBean>,
                            response: Response<CampusGuideExpressDeliveryBean>
                        ) {
                            if (response.code() == 200)
                                callback.onCampusGuideExpressDeliveryBeanReady(response.body())
                            else
                                callback.onFaire()

                        }

                    })
                apiService.getCampusGuideSubjectBean().enqueue(object : retrofit2.Callback<CampusGuideSubjectBean> {
                    override fun onFailure(call: Call<CampusGuideSubjectBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusGuideSubjectBean>,
                        response: Response<CampusGuideSubjectBean>
                    ) {
                        if (response.code() == 200)
                            callback.ononCampusGuideSubjectBeanReady(response.body())
                        else
                            callback.onFaire()

                    }

                })

                apiService.getCampusGuideManAndWomanBean()
                    .enqueue(object : retrofit2.Callback<CampusGuideManAndWomanBean> {
                        override fun onFailure(call: Call<CampusGuideManAndWomanBean>, t: Throwable) {
                            callback.onFaire()
                        }

                        override fun onResponse(
                            call: Call<CampusGuideManAndWomanBean>,
                            response: Response<CampusGuideManAndWomanBean>
                        ) {
                            if (response.code() == 200)
                                callback.onCampusGuideManAndWomanBeanReady(response.body())
                            else
                                callback.onFaire()

                        }

                    })
            }
        }
    }


}


 fun saveObject(context: Context,name: String, `object`: Any) {

    var fos: FileOutputStream? = null

    var oos: ObjectOutputStream? = null

    try {

        fos = context.openFileOutput(name, MODE_PRIVATE)

        oos = ObjectOutputStream(fos)

        oos.writeObject(`object`)

    } catch (e: Exception) {

        e.printStackTrace()

        //这里是保存文件产生异常

    } finally {

        if (fos != null) {

            try {

                fos.close()

            } catch (e: IOException) {

                //fos流关闭异常

                e.printStackTrace()

            }

        }

        if (oos != null) {

            try {

                oos.close()

            } catch (e: IOException) {

                //oos流关闭异常

                e.printStackTrace()

            }

        }

    }

}

 fun getObject(context: Context,name: String): Any? {
    var fis: FileInputStream? = null
    var ois: ObjectInputStream? = null
    try {
        fis = context.openFileInput(name)
        ois = ObjectInputStream(fis)
        return ois.readObject()
    } catch (e: Exception) {
        e.printStackTrace()
        //这里是读取文件产生异常
    } finally {
        if (fis != null) {
            try {
                fis.close()
            } catch (e: IOException) {
                //fis流关闭异常
                e.printStackTrace()
            }

        }
        if (ois != null) {
            try {
                ois.close()
            } catch (e: IOException) {
                //ois流关闭异常
                e.printStackTrace()
            }

        }
    }
    //读取产生异常，返回null
    return null
}

