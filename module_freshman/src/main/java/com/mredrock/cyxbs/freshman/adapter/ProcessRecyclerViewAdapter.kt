package com.mredrock.cyxbs.freshman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.ProcessBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemProcessBinding

/**
 * Created by Tree on 2019/8/10 22:23
 */
class ProcessRecyclerViewAdapter(val bean: ProcessBean) : RecyclerView.Adapter<ProcessRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item_process, null)
        val binding = DataBindingUtil.bind<FreshmanRecycleItemProcessBinding>(view)!!
        return ViewHolder(view,binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.bean = bean.text[position + 1]
    }

    override fun getItemCount(): Int {
        return bean.text.size-1
    }

    class ViewHolder(item: View,val binding:FreshmanRecycleItemProcessBinding) : RecyclerView.ViewHolder(item)

}
