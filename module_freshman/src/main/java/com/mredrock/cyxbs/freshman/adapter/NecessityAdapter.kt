package com.mredrock.cyxbs.freshman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemNecessityItemBinding
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemNecessityTitleBinding
import kotlinx.android.synthetic.main.freshman_recycle_item_necessity_item.view.*
import kotlinx.android.synthetic.main.freshman_recycle_item_necessity_title.view.*

class NecessityAdapter constructor(val bean: NecessityBean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var titleBinding: FreshmanRecycleItemNecessityTitleBinding
    private lateinit var itemBinding: FreshmanRecycleItemNecessityItemBinding
    lateinit var list: List<String>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        titleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.freshman_recycle_item_necessity_title,
            parent,
            false
        )
        itemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.freshman_recycle_item_necessity_item,
            parent,
            false
        )

        when (viewType) {
            0 -> {
//                val view =
//                    LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item_necessity_title, parent)
                val binding = DataBindingUtil.inflate<FreshmanRecycleItemNecessityTitleBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.freshman_recycle_item_necessity_title,
                    parent,
                    false
                )
                return TitleViewHolder(binding.root, binding)

            }
            else -> {
//                val view =
//                    LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item_necessity_title, parent)
                val binding = DataBindingUtil.inflate<FreshmanRecycleItemNecessityItemBinding>(
                    LayoutInflater.from(parent.context), R.layout.freshman_recycle_item_necessity_item, parent, false
                )
                return ItemViewHolder(binding.root, binding)

            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var beanNum: Int = 0
        var flag = 0
        var lastFlag = 0
        for (textBean in bean.text) {
            if (textBean.data == null)
                break
            flag += textBean.data.size + 1
            if (position < flag) {
                break
            }
            lastFlag = flag

            beanNum++
        }
        LogUtils.d(
            "MyTag",
            "position=$position,beanNum=$beanNum,flag=$flag,lastFlag=$lastFlag,title=${holder is TitleViewHolder}"
        )
        when {
            holder is TitleViewHolder -> {
                if (bean.text[beanNum].data != null)
                    holder.binding?.bean = bean.text[beanNum]
            }
            holder is ItemViewHolder -> {
                if (bean.text[beanNum].data != null)
                    holder.binding?.bean = bean.text[beanNum].data[position - lastFlag - 1]
            }
        }


    }

    override fun getItemCount(): Int {
        var num: Int = 0
        for (textBean in bean.text) {
            if (textBean.data != null)
                num += textBean.data.size
        }
        num += bean.text.size
        return num

    }

    override fun getItemViewType(position: Int): Int {
        var index = 0
        for (textBean in bean.text) {
            if (index == position) {
                return 0
            }
            if (textBean.data != null)
                index += textBean.data.size + 1
        }
        return 1

    }
}

class MyViewHolder(item: View) : RecyclerView.ViewHolder(item)
class TitleViewHolder(item: View, val binding: FreshmanRecycleItemNecessityTitleBinding) :
    RecyclerView.ViewHolder(item) {
    val textView: TextView = item.tv_necessity_title

}

class ItemViewHolder(item: View, val binding: FreshmanRecycleItemNecessityItemBinding) : RecyclerView.ViewHolder(item) {
    val textView_title: TextView = item.tv_necessity_item_name
    val textView_detail: TextView = item.tv_necessity_detail
}