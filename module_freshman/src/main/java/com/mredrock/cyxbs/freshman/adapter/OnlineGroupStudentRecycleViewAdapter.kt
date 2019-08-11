package com.mredrock.cyxbs.freshman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.GroupStudentBean
import kotlinx.android.synthetic.main.freshman_recycle_view_item_online_group.view.*

/**
 * Created by Tree on 2019/8/11 11:05
 */
class OnlineGroupStudentRecycleViewAdapter(val bean: GroupStudentBean): RecyclerView.Adapter<OnlineGroupStudentRecycleViewAdapter.ViewHolder>() {


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

    }

    override fun getItemCount(): Int {
        return bean.text.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}