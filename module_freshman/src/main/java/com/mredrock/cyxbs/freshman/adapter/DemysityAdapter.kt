package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideDemystifyBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemDemystifyBinding
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemNecessityItemBinding
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemNecessityTitleBinding
import com.mredrock.cyxbs.freshman.ui.acivity.DemystifyDetailActivity
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * Created by Tree on 2019/8/6 10:22
 */
class DemysityAdapter(val context: Context, val campusGuideDemystifyBean: CampusGuideDemystifyBean) :
    RecyclerView.Adapter<DemysityAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<FreshmanRecycleItemDemystifyBinding>(
            LayoutInflater.from(parent.context),
            R.layout.freshman_recycle_item_demystify,
            parent,
            false
        )
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.bean = campusGuideDemystifyBean.text[position]
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, DemystifyDetailActivity::class.java).apply {
                putExtra("bean", campusGuideDemystifyBean.text[position])
            })
        }
    }


    override fun getItemCount(): Int {
        return campusGuideDemystifyBean.text.size
    }

    class ViewHolder(item: View, val binding: FreshmanRecycleItemDemystifyBinding?) : RecyclerView.ViewHolder(item)
}
