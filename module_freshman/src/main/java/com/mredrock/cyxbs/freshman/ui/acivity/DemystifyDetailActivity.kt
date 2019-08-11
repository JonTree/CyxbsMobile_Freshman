package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import android.transition.Fade
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.adapter.DemysityDetailViewPagerAdapter
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideManAndWomanBean
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean
import com.mredrock.cyxbs.freshman.util.gson
import kotlinx.android.synthetic.main.freshman_activity_demystify_detail.*
import kotlinx.android.synthetic.main.freshman_view_pager_page_demystify_male_female_ratio.*
import org.greenrobot.eventbus.Subscribe


class DemystifyDetailActivity : BaseActivity() {

    var isFirst = true


    override val isFragmentActivity: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mredrock.cyxbs.freshman.R.layout.freshman_activity_demystify_detail)

        common_toolbar.init(
            title = "数据揭秘"
        )

    }

    @Subscribe(sticky = true)
    fun upData(campusGuideManAndWomanBean: CampusGuideManAndWomanBean) {
        vp_demystify_detail.adapter = DemysityDetailViewPagerAdapter(
            this,
            intent.getSerializableExtra("bean") as CampusGuideSubjectBean,
            campusGuideManAndWomanBean,
            intent.getIntExtra("position", -1)
        )
        tl_demystify_detail.setupWithViewPager(vp_demystify_detail)
        vp_demystify_detail.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (isFirst) {
                    if (position == 1) {
                        fpcv_man_woamn_data.doAnimation()
                        isFirst = false
                    }
                }
            }
        })
    }

}
