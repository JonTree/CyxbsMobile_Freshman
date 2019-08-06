package com.mredrock.cyxbs.freshman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideDemystifyBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemDemystifyBinding
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemNecessityItemBinding

/**
 * Created by Tree on 2019/8/6 10:22
 */
class DemysityAdapter(val campusGuideDemystifyBean: CampusGuideDemystifyBean) : RecyclerView.Adapter<DemysityAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item_demystify, null)
        val binding = DataBindingUtil.bind<FreshmanRecycleItemDemystifyBinding>(view)
        return ViewHolder(view,binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.bean = campusGuideDemystifyBean.text[position]
    }


    override fun getItemCount(): Int {
        return campusGuideDemystifyBean.text.size
    }

    class ViewHolder(item: View, val binding: FreshmanRecycleItemDemystifyBinding?) : RecyclerView.ViewHolder(item)
}
