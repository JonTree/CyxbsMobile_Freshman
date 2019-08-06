package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.Interpolator
import android.widget.Scroller
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideDemystifyBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerDormitoryAndCanteenPageBinding
import com.mredrock.cyxbs.freshman.event.UpdataViewPagerAutoSlideEvent
import kotlinx.android.synthetic.main.freshman_view_pager_dormitory_and_canteen_page.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_item_demystify_male_female_ratio.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_item_demystify_subject_data.view.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by Tree on 2019/8/6 22:31
 */
class DemysityDetailAdapter(val context: Context, val bean: CampusGuideDemystifyBean.TextBean.MessageBean) :
    PagerAdapter() {


    private val pagerList = ArrayList<View>()

    init {
        pagerList.add(View.inflate(
            context,
            R.layout.freshman_view_pager_item_demystify_subject_data,
            null
        ).apply {
            fhv_subject_data.bindData(
                bean.data.map { it.subject }.determineIfTheSizeIsAppropriate(),
                bean.data.map { it.data.substringBefore("%").toFloat() }.determineIfTheSizeIsAppropriate()
            )
        })
         pagerList.add(View.inflate(
            context,
            R.layout.freshman_view_pager_item_demystify_male_female_ratio,
            null
        ).apply {
            fpcv_man_woamn_data.setManProportion(bean.boy.substringBefore("%").toFloat())
        })

    }

    fun <T> List<T>.determineIfTheSizeIsAppropriate(): List<T>? {
        if (size != 3) {
            return null
        }
        return this
    }


    override fun getCount(): Int {
        return 2
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
