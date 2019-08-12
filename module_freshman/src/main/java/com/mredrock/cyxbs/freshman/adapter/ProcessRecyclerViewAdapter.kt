package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.bean.ProcessBean
import com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemProcessBinding
import com.mredrock.cyxbs.freshman.updata.IMAGE_BASE_URI
import com.mredrock.cyxbs.freshman.util.Util
import kotlinx.android.synthetic.main.freshman_recycle_item_process.view.*
import org.jetbrains.anko.imageBitmap

/**
 * Created by Tree on 2019/8/10 22:23
 */
class ProcessRecyclerViewAdapter(val bean: ProcessBean) : RecyclerView.Adapter<ProcessRecyclerViewAdapter.ViewHolder>() {
    lateinit var context:Context

    private var isOpen = mutableListOf<Boolean>()

    private var photoList:List<String>? = null

    private val viewHolderList = mutableListOf<ProcessRecyclerViewAdapter.ViewHolder?>()


    init {
        for (text in  bean.text) {
            text.photo = "$IMAGE_BASE_URI${text.photo}"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item_process, null)
        val binding = DataBindingUtil.bind<FreshmanRecycleItemProcessBinding>(view)!!
        for (i in 0 until bean.text.size - 1) {
            isOpen.add(false)
            viewHolderList.add(null)
        }
        context = parent.context
        return ViewHolder(view,binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        viewHolderList[position] = holder
        holder.binding.bean = bean.text[position + 1]
        holder.itemView.apply {
            if (isOpen[position]) {
                iv_arrow_indicator.imageBitmap = BitmapFactory.decodeResource(context.resources,R.drawable.freshman_more_function_arrow_top)
                ll_process.visibility = View.VISIBLE
            }else{
                iv_arrow_indicator.imageBitmap = BitmapFactory.decodeResource(context.resources,R.drawable.freshman_more_function_arrow_bottom)
                ll_process.visibility = View.GONE
            }
            ll_process_on_click.setOnClickListener {
                if (isOpen[position]){
                    iv_arrow_indicator.imageBitmap = BitmapFactory.decodeResource(context.resources,R.drawable.freshman_more_function_arrow_bottom)
                    ll_process.visibility = View.GONE
                    isOpen[position] = !isOpen[position]
                }else{
                    viewHolderList.forEach { it?.let { it.itemView.ll_process.visibility = View.GONE }}
                    for (i in 0 until isOpen.size) {
                        isOpen[i] = false
                    }
                    iv_arrow_indicator.imageBitmap = BitmapFactory.decodeResource(context.resources,R.drawable.freshman_more_function_arrow_top)
                    ll_process.visibility = View.VISIBLE
                    isOpen[position] = !isOpen[position]
                }
            }



        }



    }

    override fun getItemCount(): Int {
        return bean.text.size-1
    }

    class ViewHolder(item: View,val binding:FreshmanRecycleItemProcessBinding) : RecyclerView.ViewHolder(item)

}
