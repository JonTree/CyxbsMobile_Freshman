package com.mredrock.cyxbs.freshman.util

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import org.jetbrains.anko.imageBitmap

/**
 * Created by Tree on 2019/8/4 20:12
 */
class DormitoryCarouselViewPagerAdapter(val context: Context, val bean: CampusGuideBasicBean.TextBean) :

    PagerAdapter() {

    override fun getCount(): Int {
        return Int.MAX_VALUE
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeAllViews()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val list  = bean.message.flatMap { it.photos }
        var i = position

        i = if ((i + 1) % list.size != 0) {
            (i + 1) % list.size - 1
        } else {
            1
        }
        return  ImageView(context).apply {
            layoutParams =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }.let { Util.loadImage(it, list[i], null) }
    }

}
