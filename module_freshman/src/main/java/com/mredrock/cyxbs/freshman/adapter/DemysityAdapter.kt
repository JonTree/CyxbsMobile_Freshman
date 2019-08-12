package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.CampusGuideSubjectBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemDemystifyBinding
import com.mredrock.cyxbs.freshman.ui.acivity.DemystifyDetailActivity

/**
 * Created by Tree on 2019/8/6 10:22
 */
class DemysityAdapter(val context: Context, val bean: CampusGuideSubjectBean) :
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
        holder.binding?.bean = bean.text[position]
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, DemystifyDetailActivity::class.java).apply {
                putExtra("position",position)
                putExtra("memo",bean)
            })
        }
    }


    override fun getItemCount(): Int {
        return bean.text.size
    }

    class ViewHolder(item: View, val binding: FreshmanRecycleItemDemystifyBinding?) : RecyclerView.ViewHolder(item)
}
