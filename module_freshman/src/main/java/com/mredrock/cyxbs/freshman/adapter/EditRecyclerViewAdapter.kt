package com.mredrock.cyxbs.freshman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import com.mredrock.cyxbs.freshman.event.UpDataMemo
import kotlinx.android.synthetic.main.freshman_recycle_item__memo.view.*
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.textColor

/**
 * Created by Tree on 2019/8/10 10:09
 */
class EditRecyclerViewAdapter (private val delete: TextView, val memo:NecessityBean.TextBean): RecyclerView.Adapter<EditRecyclerViewAdapter.ViewHolder>() {

    private val isCheck = mutableListOf<Boolean>()
    private var count = 0



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        isCheck.clear()
        memo.data.forEach {
            isCheck.add(false)
        }
        delete.setOnClickListener {
           memo.data = memo.data.filter { !isCheck[ memo.data.indexOf(it)]}
           EventBus.getDefault().postSticky(UpDataMemo(memo).apply { isEdit = true })
            (parent.context as AppCompatActivity).finish()
        }
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item__memo, null))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            tv_item_tiltle.text =  memo.data[position].name
            check_box_item_tiltle.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    isCheck[position] = true
                    count++
                    delete.text = "删除（${count}）"
                    delete.textColor = 0xFFffffff.toInt()
                } else {
                    isCheck[position] = false
                    count--
                    if (count != 0) {
                        delete.text = "删除（${count}）"
                        delete.textColor = 0xffffffff.toInt()
                    }else{
                        delete.text = "删除"
                        delete.textColor = 0xff747474.toInt()
                    }
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return  memo.data.size
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item)

}
