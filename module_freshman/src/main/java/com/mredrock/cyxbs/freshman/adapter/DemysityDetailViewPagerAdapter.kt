package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideManAndWomanBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean
import kotlinx.android.synthetic.main.freshman_view_pager_page_demystify_male_female_ratio.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_item_demystify_subject_data.view.*

/**
 * Created by Tree on 2019/8/6 22:31
 */
class DemysityDetailViewPagerAdapter(val context: Context, val bean1: CampusGuideSubjectBean, val bean2:CampusGuideManAndWomanBean, val position: Int) :
    PagerAdapter() {



    private val pagerList = ArrayList<View>()

    init {
        if (position != -1) {
            pagerList.add(View.inflate(
                context,
                R.layout.freshman_view_pager_item_demystify_subject_data,
                null
            ).apply {
                fhv_subject_data.bindData(
                    bean1.text[position].message.map { it.subject}.determineIfTheSizeIsAppropriate(),
                    bean1.text[position].message.map { it.data.toFloat()}.determineIfTheSizeIsAppropriate()
                )
            })
            pagerList.add(View.inflate(
                context,
                R.layout.freshman_view_pager_page_demystify_male_female_ratio,
                null
            ).apply {
                fpcv_man_woamn_data.setManProportion(bean2.text[position].boy.substringBefore("%").toFloat()/100)
            })
        }

    }

    private fun <T> List<T>.determineIfTheSizeIsAppropriate(): List<T>? {
        if (size != 3) {
            return null
        }
        return this
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> bean1.title
            1 -> bean1.title
            else -> ""
        }
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
