package com.mredrock.cyxbs.freshman.util

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import java.math.MathContext

/**
 * Created by Tree on 2019/8/3 11:12
 */
class ExpressDeliveryViewPagerAdapter(val context: Context) : PagerAdapter() {


    val list = listOf("顺丰","韵达","中通","圆通","中通","邮政","菜鸟驿站（校外）","百世")

    private val pagerList = ArrayList<View>()



    init {
        list.forEach {
            pagerList.add(
                View.inflate(
                    context,
                    R.layout.freshman_view_pager_page_scroll_view_item_express_delivery,
                    null
                )
            )}
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return false
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(pagerList[position])
        //每次滑动的时候把视图添加到viewpager
        return pagerList[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(pagerList[position])
    }

}
