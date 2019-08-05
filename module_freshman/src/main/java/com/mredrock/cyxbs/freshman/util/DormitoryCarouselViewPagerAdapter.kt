package com.mredrock.cyxbs.freshman.util

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerItemCarouselBinding
import org.jetbrains.anko.image
import org.jetbrains.anko.imageBitmap

/**
 * Created by Tree on 2019/8/4 20:12
 */
class DormitoryCarouselViewPagerAdapter(val context: Context, val bean: CampusGuideBasicBean.TextBean) :
    PagerAdapter() {

    val list = ObservableArrayList<String>()


    init {
        bean.message.flatMap { it.photos }.forEach { list.add(it) }
    }

    override fun getCount(): Int {
        return Int.MAX_VALUE

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var i = position

        i = if ((i + 1) % list.size != 0) {
            (i + 1) % list.size - 1
        } else {
            1
        }

        val view = View.inflate(context, R.layout.freshman_view_pager_item_carousel, null)
        val binding = DataBindingUtil.bind<FreshmanViewPagerItemCarouselBinding>(view)
        binding?.uri = list[i]
        container.addView(view)
        return view
    }

}
