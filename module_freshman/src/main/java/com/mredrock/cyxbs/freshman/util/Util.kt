package com.mredrock.cyxbs.freshman.util

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.updata.APIService
import com.mredrock.cyxbs.freshman.updata.ApiGenerator

val gson = Gson()

val apiService = ApiGenerator.getApiService(APIService::class.java)



object Util {
    @JvmStatic
    @BindingAdapter(value = ["imageUrl", "error"], requireAll = false)
    fun loadImage(view: ImageView, url: String, error: Drawable?) {
        if (url != "") {
            Glide.with(view.context).load(url).apply(RequestOptions().placeholder(R.drawable.common_place_holder)).into(view)
        }
    }


}
