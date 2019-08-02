package com.mredrock.cyxbs.freshman.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.NecessityViewModel

class NecessityActivity : BaseActivity() {
    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_necessity)
        val titleBinding = DataBindingUtil.setContentView<com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemNecessityTitleBinding>(this,R.layout.freshman_recycle_item_necessity_title)
        val itemBinding = DataBindingUtil.setContentView<com.mredrock.cyxbs.freshman.databinding.FreshmanRecycleItemNecessityItemBinding>(this,R.layout.freshman_recycle_item_necessity_item)
        val viewModel = ViewModelProviders.of(this).get(NecessityViewModel::class.java)
        val vm : Deliverable = viewModel


        titleBinding.lifecycleOwner = this
        itemBinding.lifecycleOwner = this
    }
}
