package com.mredrock.cyxbs.freshman.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.maning.imagebrowserlibrary.ImageEngine

class MyImageEngine :ImageEngine{
    override fun loadImage(context: Context?, url: String?, imageView: ImageView?, progressView: View?) {
        Glide.with(context!!).load(url!!).into(imageView!!)
    }

}