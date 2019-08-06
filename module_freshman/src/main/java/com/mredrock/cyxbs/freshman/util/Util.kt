package com.mredrock.cyxbs.freshman.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.Gson

val gson = Gson()


object Util {
    @BindingAdapter(value = ["imageUrl", "error"], requireAll = false)
    fun loadImage(view: ImageView, url: String, error: Drawable) {
        Glide.with(view.context).load(url).into(view)
    }
}
