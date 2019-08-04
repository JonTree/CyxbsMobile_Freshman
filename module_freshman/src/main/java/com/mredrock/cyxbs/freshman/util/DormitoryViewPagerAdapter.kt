package com.mredrock.cyxbs.freshman.util

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import kotlinx.android.synthetic.main.freshman_view_pager_express_delivery_page.view.*

/**
 * Created by Tree on 2019/8/3 22:37
 */
class DormitoryViewPagerAdapter(val context: Context): PagerAdapter() {


    val list = listOf("知行苑","明理苑","宁静苑","兴业苑")

    private val pagerList = ArrayList<View>()



    init {
        repeat(list.size) {
            pagerList.add(
                View.inflate(
                    context,
                    R.layout.freshman_view_pager_dormitory_page,
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
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(pagerList[position])
        return pagerList[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(pagerList[position])
    }
}
