package com.mredrock.cyxbs.freshman.util

import android.view.View
import androidx.viewpager.widget.PagerAdapter

/**
 * Created by Tree on 2019/8/3 11:12
 */
class ExpressDeliveryViewPagerAdapter : PagerAdapter() {


    val list = listOf<String>("顺丰","韵达","中通","圆通","中通","邮政","菜鸟驿站（校外）","百世")

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return false
    }
}
