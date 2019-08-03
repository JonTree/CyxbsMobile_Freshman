package com.mredrock.cyxbs.freshman.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemNecessityItemBinding
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemNecessityTitleBinding
import kotlinx.android.synthetic.main.freshman_recycle_item_necessity_title.view.*

class NecessityAdapter constructor(val bean:NecessityBean): RecyclerView.Adapter<MyViewHolder>() {
    private lateinit var titleBinding:FreshmanRecycleItemNecessityTitleBinding
    private lateinit var itemBinding:FreshmanRecycleItemNecessityItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        titleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.freshman_recycle_item_necessity_title,parent,false)
        itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.freshman_recycle_item_necessity_item,parent,false)


        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item_necessity_title,parent))
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 9

    }

    override fun getItemViewType(position: Int): Int {

        return super.getItemViewType(position)

    }
}
class MyViewHolder(item: View) : RecyclerView.ViewHolder(item)
class TitleViewHolder(item: View) : RecyclerView.ViewHolder(item){
    init {
        item.tv_necessity_title
    }
}
class ItemViewHolder(item: View) : RecyclerView.ViewHolder(item){

}