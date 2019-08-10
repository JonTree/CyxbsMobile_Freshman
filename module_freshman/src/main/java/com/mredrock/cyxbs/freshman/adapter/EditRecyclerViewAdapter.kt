package com.mredrock.cyxbs.freshman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import kotlinx.android.synthetic.main.freshman_recycle_item__memo.view.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by Tree on 2019/8/10 10:09
 */
class EditRecyclerViewAdapter (private val textView: TextView): RecyclerView.Adapter<EditRecyclerViewAdapter.ViewHolder>() {


    val list = listOf("身份证", "录取通知书", "高考准考证")
    private val isCheck = mutableListOf<Boolean>()
    private var count = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        list.forEach {
            isCheck.add(false)
        }
        textView.setOnClickListener {
           EventBus.getDefault().post( list.filter { !isCheck[list.indexOf(it)] })
            (parent.context as AppCompatActivity).finish()
        }
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item__memo, null))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            tv_item_tiltle.text = list[position]
            check_box_item_tiltle.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    isCheck[position] = true
                    count++
                    textView.text = "删除（${count}）"
                } else {
                    isCheck[position] = false
                    count--
                    if (count != 0) {
                        textView.text = "删除（${count}）"
                    }else{
                        textView.text = "删除"
                    }
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item)

}
