package com.mredrock.cyxbs.freshman.ui.acivity

import android.Manifest
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.utils.extensions.doPermissionAction
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.CampusGuideViewModel
import com.mredrock.cyxbs.freshman.data.ViewModel.MoreFunctionViewModel
import com.mredrock.cyxbs.freshman.databinding.FreshmanActivityMoreFuntionBinding
import kotlinx.android.synthetic.main.freshman_activity_more_funtion.*
import org.jetbrains.anko.sdk27.coroutines.onLongClick
import android.view.Gravity
import android.view.LayoutInflater
import android.graphics.drawable.BitmapDrawable
import android.widget.LinearLayout
import android.widget.PopupWindow
import com.mredrock.cyxbs.common.BaseApp
import com.mredrock.cyxbs.freshman.data.Model.saveBitmap
import kotlinx.android.synthetic.main.freshman_popuo_layout.view.*


class MoreFunctionActivity : BaseViewModelActivity<MoreFunctionViewModel>(){
    override val viewModelClass: Class<MoreFunctionViewModel> = MoreFunctionViewModel::class.java

    override val isFragmentActivity: Boolean = false
    var dialogOpen:ObservableBoolean = ObservableBoolean(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = DataBindingUtil.setContentView<FreshmanActivityMoreFuntionBinding>(this,R.layout.freshman_activity_more_funtion)

        bind.activity = this



        common_toolbar.init(
            title = "更多功能"
        )
        initPopupWindow()
        initImg()
    }

    fun onClick(index:Int){
        when(index){
            0->{}
            1->{}
            2->{

                dialogOpen.set(!dialogOpen.get())
                LogUtils.d("MyTag","Click${dialogOpen.get()}")
            }
        }
    }
    fun initImg(){
        img_vx.setOnLongClickListener {

            this.doPermissionAction(Manifest.permission.WRITE_EXTERNAL_STORAGE){
                reason = "保存文件需要文件存储权限"
                doAfterGranted {
                    showPopWindow()
                }
            }
            return@setOnLongClickListener true
        }
    }
    fun dismissDialog(){
        dialogOpen.set(!dialogOpen.get())
    }
    fun nullClick(){}
    override fun onBackPressed() {
        if(dialogOpen.get()){
            dialogOpen.set(!dialogOpen.get())
            if(popupWindow!=null){
                if(popupWindow!!.isShowing)
                    popupWindow!!.dismiss()
            }
        }
        else
            super.onBackPressed()
    }
    private var content:View? = null
    private var popupWindow:PopupWindow? =null
    private fun initPopupWindow() {
        //要在布局中显示的布局
        content = LayoutInflater.from(this).inflate(R.layout.freshman_popuo_layout, null, false)

        //实例化PopupWindow并设置宽高
        popupWindow =
            PopupWindow(content, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        popupWindow?.setBackgroundDrawable(BitmapDrawable())
        //点击外部消失，这里因为PopupWindow填充了整个窗口，所以这句代码就没用了
        popupWindow?.setOutsideTouchable(true)
        //设置可以点击
        popupWindow?.setTouchable(true)
        content!!.tv_save_popup_layout.setOnClickListener {
            viewModel.showToase()
            val bitmap = BitmapFactory.decodeResource(this.resources,R.drawable.freshman_more_function_qr_code)
            saveBitmap(bitmap,"vx_qr_code",this)
            if(popupWindow!!.isShowing)
                popupWindow!!.dismiss()
        }
        content!!.tv_cancel_popup_layout.setOnClickListener {
            if(popupWindow!!.isShowing)
                popupWindow!!.dismiss()
            dialogOpen.set(!dialogOpen.get())
        }
        //进入退出的动画
        popupWindow?.setAnimationStyle(com.mredrock.cyxbs.freshman.R.style.Animation_AppCompat_DropDownUp)
    }

    private fun showPopWindow() {

        popupWindow?.showAtLocation(fl_more_function, Gravity.BOTTOM, 0, 0)
    }


}

