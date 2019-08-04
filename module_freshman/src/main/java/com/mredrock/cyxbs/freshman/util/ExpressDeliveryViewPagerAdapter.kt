package com.mredrock.cyxbs.freshman.util

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import kotlinx.android.synthetic.main.freshman_view_pager_express_delivery_page.view.*
import java.math.MathContext

/**
 * Created by Tree on 2019/8/3 11:12
 */
class ExpressDeliveryViewPagerAdapter(val context: Context,var bean:CampusGuideBasicBean.TextBean) : PagerAdapter() {


    val list = listOf("顺丰","韵达","中通","圆通","中通","邮政","菜鸟驿站（校外）","百世")

    private val pagerList = ArrayList<View>()



    init {
        for(msg in bean.message) {
            val view = View.inflate(
                context,
                R.layout.freshman_view_pager_express_delivery_page,
                null
            )
            val bind = DataBindingUtil.bind<com.mredrock.cyxbs.freshman.databinding.FreshmanViewPagerExpressDeliveryPageBinding>(view)
            bind?.text = msg.name
            pagerList.add(
                view
            )}
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return bean.message[position].name
    }

    override fun getCount(): Int {
        return bean.message.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        pagerList[position].ll_express_delivery_container.addView(
//            View.inflate(
//                context,
//                R.layout.freshman_view_pager_page_scroll_view_item_express_delivery,
//                null
//            )
//        )
        for(msg in bean.message[position].detail)
        container.addView(pagerList[position])
        return pagerList[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(pagerList[position])
    }

}
