package com.mredrock.cyxbs.freshman.adapter

import android.view.View
import androidx.viewpager.widget.PagerAdapter

/**
 * Created by Tree on 2019/8/5 19:57
 */
class DemystifyViewPagerAdapter : PagerAdapter() {
    override fun getCount(): Int {
        return 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return false
    }
}
