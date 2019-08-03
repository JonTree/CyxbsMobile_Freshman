package com.mredrock.cyxbs.freshman.ui.acivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import android.widget.ImageButton
import android.widget.LinearLayout
import com.mredrock.cyxbs.freshman.ui.fragment.CanteenFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DemystifyFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DormitoryFragment
import com.mredrock.cyxbs.freshman.ui.fragment.ExpressDeliveryFragment
import kotlinx.android.synthetic.main.freshman_activity_campus_guide.*
import com.mredrock.cyxbs.freshman.data.ViewModel.CampusGuideViewModel


class CampusGuideActivity : BaseViewModelActivity<CampusGuideViewModel>(),View.OnClickListener  {
    override val viewModelClass: Class<CampusGuideViewModel> = CampusGuideViewModel::class.java
//        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.

    lateinit var canteenFragment: CanteenFragment
    lateinit var demystifyFragment: DemystifyFragment
    lateinit var dormitoryFragment: DormitoryFragment
    lateinit var expressDeliveryFragment: ExpressDeliveryFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_campus_guide)
        canteenFragment = CanteenFragment()
    }



    //处理Tab的点击事件
    override fun onClick(v: View) {
        //先将四个ImageButton置为灰色
        resetImgs()
        when (v.id) {
            R.id.tv_tab_dormitories -> selectTab(0)
            R.id.tv_tab_canteen -> selectTab(1)
            R.id.tv_tab_express_delivery -> selectTab(2)
            R.id.tv_tab_demystify -> selectTab(3)
        }
    }

    //进行选中Tab的处理
    private fun selectTab(i: Int) {
        //获取FragmentManager对象
        val manager = supportFragmentManager
        //获取FragmentTransaction对象
        val transaction = manager.beginTransaction()
        //先隐藏所有的Fragment
        hideFragments(transaction)
        when (i) {
            //当选中点击的是微信的Tab时
            0 -> {
                //设置微信的ImageButton为绿色
                mWeixinImg.setImageResource(R.mipmap.tab_weixin_pressed)
                //如果微信对应的Fragment没有实例化，则进行实例化，并显示出来
                if (mFragWeinxin == null) {
                    mFragWeinxin = WeixinFragment()
                    transaction.add(R.id.id_content, mFragWeinxin)
                } else {
                    //如果微信对应的Fragment已经实例化，则直接显示出来
                    transaction.show(mFragWeinxin)
                }
            }
            1 -> {
                mFrdImg.setImageResource(R.mipmap.tab_find_frd_pressed)
                if (mFragFrd == null) {
                    mFragFrd = FrdFragment()
                    transaction.add(R.id.id_content, mFragFrd)
                } else {
                    transaction.show(mFragFrd)
                }
            }
            2 -> {
                mAddressImg.setImageResource(R.mipmap.tab_address_pressed)
                if (mFragAddress == null) {
                    mFragAddress = AddressFragment()
                    transaction.add(R.id.id_content, mFragAddress)
                } else {
                    transaction.show(mFragAddress)
                }
            }
            3 -> {
                mSettingImg.setImageResource(R.mipmap.tab_settings_pressed)
                if (mFragSetting == null) {
                    mFragSetting = SettingFragment()
                    transaction.add(R.id.id_content, mFragSetting)
                } else {
                    transaction.show(mFragSetting)
                }
            }
        }
        //不要忘记提交事务
        transaction.commit()
    }

    //将四个的Fragment隐藏
    private fun hideFragments(transaction: FragmentTransaction) {
        if (mFragWeinxin != null) {
            transaction.hide(mFragWeinxin)
        }
        if (mFragFrd != null) {
            transaction.hide(mFragFrd)
        }
        if (mFragAddress != null) {
            transaction.hide(mFragAddress)
        }
        if (mFragSetting != null) {
            transaction.hide(mFragSetting)
        }
    }

    //将四个ImageButton置为灰色
    private fun resetImgs() {
        tv_tab_canteen.setTextColor(0x00000000)
        tv_tab_demystify.setTextColor(0x00000000)
        tv_tab_dormitories.setTextColor(0x00000000)
        tv_tab_express_delivery.setTextColor(0x00000000)
    }

}
