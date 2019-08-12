package com.mredrock.cyxbs.freshman.data.ViewModel

import android.graphics.BitmapFactory
import com.mredrock.cyxbs.common.BaseApp
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.Model.saveBitmap

class MoreFunctionViewModel: BaseViewModel() {
    fun showToase(){
        toastEvent.value = R.string.freshman_save_success
    }

}