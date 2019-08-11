package com.mredrock.cyxbs.freshman.ui.acivity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.mredrock.cyxbs.common.component.PhotoViewerActivity
import org.jetbrains.anko.startActivity

fun showPhotos(context: Context, photoList: List<String>, pos: Int = 0) {
    context.startActivity<MyPhotoViewActivity>("photos" to photoList.toTypedArray(), "position" to pos)
}
class MyPhotoViewActivity : PhotoViewerActivity() {
    override fun onPageSelect(position: Int) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }
}