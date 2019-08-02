package com.mredrock.cyxbs.freshman.util

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R

class NecessityAdapter : RecyclerView.Adapter<ViewHodler>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHodler {

//        return ViewHodler(LayoutInflater.from(viewGroup.context).inflate(R.layout,viewGroup,false))
    }

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {

    }

    override fun getItemCount(): Int {
        return 9
    }
}

class ViewHodler(item: View) : RecyclerView.ViewHolder(item){
    init {
//        item.iv_background_picture
    }
}