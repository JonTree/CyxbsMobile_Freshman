package com.mredrock.cyxbs.freshman.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.GroupStudentBean
import com.mredrock.cyxbs.freshman.ui.acivity.OnlineCommunicationActivity
import kotlinx.android.synthetic.main.freshman_dailog_item.view.*
import kotlinx.android.synthetic.main.freshman_recycle_view_item_online_group.view.*

/**
 * Created by Tree on 2019/8/11 11:05
 */
class OnlineGroupStudentRecycleViewAdapter(val bean: GroupStudentBean,val context: Context): RecyclerView.Adapter<OnlineGroupStudentRecycleViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.freshman_recycle_view_item_online_group,
                null
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_group_title.text = bean.text[position].name
        holder.itemView.cl_online_group_click.setOnClickListener {
            val activity = (context as OnlineCommunicationActivity)
            activity.view?.apply {
                tv_group_name.text = bean.text[position].name
                tv_group_qq_num.text = bean.text[position].data
                tv_group_confirm.setOnClickListener {
                    val  mClipData = ClipData.newPlainText("Label",bean.text[position].data)
                    (activity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).primaryClip = mClipData

                    ll_fsv.visibility = View.VISIBLE
                    fsv.doAnimation()
                    fsv.setOnAnimationDoneListener {
                        ll_fsv.visibility = View.GONE
                        activity.dialog?.dismiss()
                    }
                }
            }
            activity.view?.ll_fsv?.visibility = View.GONE
            activity.dialog?.show()
        }

    }

    override fun getItemCount(): Int {
        return bean.text.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}