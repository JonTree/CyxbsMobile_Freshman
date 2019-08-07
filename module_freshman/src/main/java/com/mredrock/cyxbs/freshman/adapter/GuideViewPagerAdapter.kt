package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.BusWayBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerPagerGuidedBinding
import kotlinx.android.synthetic.main.freshman_view_pager_item_demystify_subject_data.view.*

/**
 * Created by Tree on 2019/8/7 16:24
 */
class GuideViewPagerAdapter(val context:Context,val busWayBean: BusWayBean) : PagerAdapter() {


    private val pagerList = ArrayList<View>()

    init {
        pagerList.add(View.inflate(
            context,
            R.layout.freshman_view_pager_pager_guided,
            null
        ).apply {
            DataBindingUtil.bind<FreshmanViewPagerPagerGuidedBinding>(this)?.bean = busWayBean
        })
//        pagerList.add(View.inflate(
//            context,
//            R.layout.freshman_view_pager_item_demystify_male_female_ratio,
//            null
//        ).apply {
//
//        })

    }


    override fun getCount(): Int {
        return pagerList.size
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
