package com.mredrock.cyxbs.freshman.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.event.UpdataViewPagerAutoSlideEvent
import com.mredrock.cyxbs.freshman.adapter.DormitoryViewPagerAdapter
import com.mredrock.cyxbs.freshman.event.UpdataViewPagerAutoSlide2Event
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.freshman_fragment_dormitory.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.text.FieldPosition


/**
 * Created by Tree on 2019/8/2 23:19
 */
class DormitoryCanteenFragment: BaseFragment() {


    var isPause = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.freshman_fragment_dormitory, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            tl_dormitory.tabMode = TabLayout.MODE_FIXED
    }

    override fun onResume() {
        super.onResume()
        isPause = false
    }
    @SuppressLint("CheckResult")
    @Subscribe(sticky = true)
    fun onBeanReady(bean: CampusGuideBasicBean){
        tl_dormitory.setupWithViewPager(vp_dormitory)
        val adapter =             DormitoryViewPagerAdapter(activity as Context, bean.text[0],vp_dormitory)
        vp_dormitory.adapter =adapter
        Observable.create<ViewPager> {
            while (true) {
                Thread.sleep(4000)
                if (isPause) {
                    continue
                }
                it.onNext(adapter.carouselList[adapter.position])
            }
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            it.apply {
                currentItem += 1
            }
        }
    }


    override fun onStop() {
        super.onStop()
        isPause = true
    }
}
