package com.mredrock.cyxbs.freshman.ui.acivity

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.mredrock.cyxbs.common.component.PhotoViewerActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.Model.saveBitmap
import kotlinx.android.synthetic.main.freshman_float_view.view.*
import org.jetbrains.anko.startActivity

fun showPhotos(context: Context, photoList: List<String>, pos: Int = 0) {

    context.startActivity<MyPhotoViewActivity>("photos" to photoList.toTypedArray(), "position" to pos)
}
class MyPhotoViewActivity : PhotoViewerActivity() {
    private var view :View? = null
    private var index :Int = 0
    override fun onPageSelect(position: Int) {
        view?.tv_float_now_page!!.text = "$position"
        index = position
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        view =addFloatView(R.layout.freshman_float_view)
        val list = intent.extras?.getStringArray("photos")?.toList()
        val curPos = intent.extras?.getInt("position")
        view?.tv_float_now_page!!.text = "${curPos!!+1}"
        view?.tv_float_max_page!!.text = "${list!!.size+1}"
        view?.iv_float_download!!.setOnClickListener {
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show()
            Glide.with(this).asBitmap().load(list[index]).into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {

                    saveBitmap(resource, System.currentTimeMillis().toString(),this@MyPhotoViewActivity)
                }

            })


        }
    }
}