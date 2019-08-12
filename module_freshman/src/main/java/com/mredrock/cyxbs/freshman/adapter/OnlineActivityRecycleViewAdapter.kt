package com.mredrock.cyxbs.freshman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.OnlineActivitiesBean
import com.mredrock.cyxbs.freshman.util.Util
import kotlinx.android.synthetic.main.freshman_recycle_view_item_online_acitivity.view.*

/**
 * Created by Tree on 2019/8/11 20:41
 */
class OnlineActivityRecycleViewAdapter (val bean: OnlineActivitiesBean): RecyclerView.Adapter<OnlineActivityRecycleViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.freshman_recycle_view_item_online_acitivity,
                null
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            Util.loadImage(iv_online_activity, bean.text[position].photo, null)
            tv_online_activity_tiltle.text = bean.text[position].name
        }
    }

    override fun getItemCount(): Int {
        return bean.text.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
