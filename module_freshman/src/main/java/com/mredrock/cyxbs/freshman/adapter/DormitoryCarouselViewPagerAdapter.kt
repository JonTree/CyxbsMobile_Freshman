package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.util.Util
import java.lang.StringBuilder

/**
 * Created by Tree on 2019/8/4 20:12
 */
class DormitoryCarouselViewPagerAdapter(val context: Context, val list:List<String>?) :
    PagerAdapter() {



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
        if (list != null) {
            i = if ((i + 1) % list.size != 0) {
                (i + 1) % list.size - 1
            } else {
                1
            }

            val view = ImageView(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                scaleType = ImageView.ScaleType.CENTER_CROP
            }
            Glide.with(context).load(list[i]).into(view)
            container.addView(view)
            return view
        }

    return container
    }

}
