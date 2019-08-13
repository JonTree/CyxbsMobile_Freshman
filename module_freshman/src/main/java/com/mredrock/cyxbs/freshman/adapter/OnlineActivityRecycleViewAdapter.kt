package com.mredrock.cyxbs.freshman.adapter

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.extensions.doPermissionAction
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.Model.saveBitmap
import com.mredrock.cyxbs.freshman.data.bean.OnlineActivitiesBean
import com.mredrock.cyxbs.freshman.ui.acivity.OnlineCommunicationActivity
import com.mredrock.cyxbs.freshman.updata.IMAGE_BASE_URI
import com.mredrock.cyxbs.freshman.util.Util
import kotlinx.android.synthetic.main.freshman_activity_more_funtion.*
import kotlinx.android.synthetic.main.freshman_activity_online_communication.*
import kotlinx.android.synthetic.main.freshman_activity_online_communication.view.*
import kotlinx.android.synthetic.main.freshman_activity_online_communication.view.rl_vx
import kotlinx.android.synthetic.main.freshman_popuo_layout.view.*
import kotlinx.android.synthetic.main.freshman_recycle_view_item_online_acitivity.view.*
import kotlinx.android.synthetic.main.freshman_view_pager_page_online_activity.view.*

/**
 * Created by Tree on 2019/8/11 20:41
 */
class OnlineActivityRecycleViewAdapter (val context: Context,val bean: OnlineActivitiesBean): RecyclerView.Adapter<OnlineActivityRecycleViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        initPopupWindow()
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.freshman_recycle_view_item_online_acitivity,
                null
            )
        )
    }

    lateinit var activity: OnlineCommunicationActivity

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            Util.loadImage(iv_online_activity, "$IMAGE_BASE_URI${bean.text[position].photo}", null)
            tv_online_activity_tiltle.text = bean.text[position].name
        }
        holder.itemView.ll_online_activity_button.setOnClickListener {
            activity = context as OnlineCommunicationActivity
            activity.rl_vx.visibility = View.VISIBLE
            activity.isOpen = true
            activity.rl_vx.setOnClickListener {
                it.visibility = View.GONE
                activity.isOpen = false
            }
            activity.rl_vx.img_vx.setOnLongClickListener {
                activity.doPermissionAction(Manifest.permission.WRITE_EXTERNAL_STORAGE){
                    reason = "保存文件需要文件存储权限"
                    doAfterGranted {
                        showPopWindow()
                    }
                }
                true
            }
        }
    }


    override fun getItemCount(): Int {
        return bean.text.size
    }

    private var content:View? = null
    private var popupWindow: PopupWindow? =null
    @SuppressLint("PrivateResource")
    private fun initPopupWindow() {
        //要在布局中显示的布局
        content = LayoutInflater.from(context).inflate(R.layout.freshman_popuo_layout, null, false)

        //实例化PopupWindow并设置宽高
        popupWindow =
            PopupWindow(content, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        popupWindow?.setBackgroundDrawable(BitmapDrawable())
        //点击外部消失，这里因为PopupWindow填充了整个窗口，所以这句代码就没用了
        popupWindow?.setOutsideTouchable(true)
        //设置可以点击
        popupWindow?.setTouchable(true)
        content!!.tv_save_popup_layout.setOnClickListener {
            Toast.makeText(context,"保存成功",Toast.LENGTH_SHORT).show()
            val bitmap = BitmapFactory.decodeResource(content!!.resources,R.drawable.freshman_more_function_qr_code)
            saveBitmap(bitmap,"vx_qr_code",context)
            if(popupWindow!!.isShowing)
                popupWindow!!.dismiss()
        }
        content!!.tv_cancel_popup_layout.setOnClickListener {
            if(popupWindow!!.isShowing)
                popupWindow!!.dismiss()
            activity.rl_vx.visibility = View.VISIBLE
        }
        //进入退出的动画
        popupWindow?.setAnimationStyle(R.style.Animation_AppCompat_DropDownUp)
    }

    private fun showPopWindow() {

        popupWindow?.showAtLocation(activity.view, Gravity.BOTTOM, 0, 0)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}
