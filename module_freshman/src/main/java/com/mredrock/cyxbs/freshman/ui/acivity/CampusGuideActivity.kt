package com.mredrock.cyxbs.freshman.ui.acivity

import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DemystifyFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DormitoryCanteenFragment
import com.mredrock.cyxbs.freshman.ui.fragment.ExpressDeliveryFragment
import kotlinx.android.synthetic.main.freshman_activity_campus_guide.*
import com.mredrock.cyxbs.freshman.data.ViewModel.CampusGuideViewModel
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideBasicBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanActivityCampusGuideBinding
import com.mredrock.cyxbs.freshman.util.apiService
import org.jetbrains.anko.textColor
import javax.security.auth.callback.Callback
import android.R
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.widget.Toast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.io.IOException


class CampusGuideActivity : BaseViewModelActivity<CampusGuideViewModel>() {
    override val viewModelClass: Class<CampusGuideViewModel> = CampusGuideViewModel::class.java

    override val isFragmentActivity: Boolean = true

    lateinit var binding: FreshmanActivityCampusGuideBinding

    private var canteenFragment: DormitoryCanteenFragment? = null
    private var demystifyFragment: DemystifyFragment? = null
    private var dormitoryFragment: DormitoryCanteenFragment? = null
    private var expressDeliveryFragment: ExpressDeliveryFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, com.mredrock.cyxbs.freshman.R.layout.freshman_activity_campus_guide)

        common_toolbar.init(
            title = "校园指引"
        )
        binding.activity = this
        selectTab(0)
    }


    //处理Tab的点击事件
    fun onClick(id: Int) {
        //先将四个ImageButton置为灰色
        resetImgs()
        when (id) {
            0 -> selectTab(0)
            1 -> selectTab(1)
            2 -> selectTab(2)
            3 -> selectTab(3)
        }
    }

    //进行选中Tab的处理
    private fun selectTab(i: Int) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        hideFragments(transaction)
        fun clickLogic(tab: TextView, fragment: BaseFragment?, initFragment: () -> Unit) {
            tab.textColor = 0xff4b72ff.toInt()
            tab.paint.isFakeBoldText = true
            if (fragment == null) {
                initFragment()
            } else {
                transaction.show(fragment)
            }
        }
        when (i) {
            //当选中点击的是微信的Tab时
            0 -> {
                clickLogic(tv_tab_dormitories, dormitoryFragment) {
                    dormitoryFragment = DormitoryCanteenFragment(0)
                    transaction.add(
                        com.mredrock.cyxbs.freshman.R.id.frame_layout_fragment_container_campus_guide,
                        dormitoryFragment as DormitoryCanteenFragment
                    )
                }
            }
            1 -> {

                clickLogic(tv_tab_canteen, canteenFragment) {
                    canteenFragment = DormitoryCanteenFragment(1)
                    transaction.add(
                        com.mredrock.cyxbs.freshman.R.id.frame_layout_fragment_container_campus_guide,
                        canteenFragment as DormitoryCanteenFragment
                    )
                }
            }
            2 -> {
                clickLogic(tv_tab_express_delivery, expressDeliveryFragment) {
                    expressDeliveryFragment = ExpressDeliveryFragment()
                    transaction.add(
                        com.mredrock.cyxbs.freshman.R.id.frame_layout_fragment_container_campus_guide,
                        expressDeliveryFragment as ExpressDeliveryFragment
                    )
                }
            }
            3 -> {
                clickLogic(tv_tab_demystify, demystifyFragment) {
                    demystifyFragment = DemystifyFragment()
                    transaction.add(
                        com.mredrock.cyxbs.freshman.R.id.frame_layout_fragment_container_campus_guide,
                        demystifyFragment as DemystifyFragment
                    )
                }
            }
        }
        transaction.commit()
    }

    //将四个的Fragment隐藏
    private fun hideFragments(transaction: FragmentTransaction) {
        canteenFragment?.let {
            transaction.hide(it)
        }
        dormitoryFragment?.let {
            transaction.hide(it)
        }
        expressDeliveryFragment?.let {
            transaction.hide(it)
        }
        demystifyFragment?.let {
            transaction.hide(it)
        }
    }

    private fun resetImgs() {
        fun updataTextView(tab: TextView) {
            tab.textColor = 0xff000000.toInt()
            tab.paint.isFakeBoldText = false
        }
        updataTextView(tv_tab_canteen)
        updataTextView(tv_tab_demystify)
        updataTextView(tv_tab_dormitories)
        updataTextView(tv_tab_express_delivery)
    }

}
