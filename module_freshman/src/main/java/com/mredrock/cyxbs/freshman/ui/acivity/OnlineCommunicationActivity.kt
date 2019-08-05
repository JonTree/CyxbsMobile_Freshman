package com.mredrock.cyxbs.freshman.ui.acivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.OnlineCommunicationViewModel
import kotlinx.android.synthetic.main.freshman_activity_online_communication.*

class OnlineCommunicationActivity : BaseViewModelActivity<OnlineCommunicationViewModel>() {
    override val viewModelClass: Class<OnlineCommunicationViewModel> = OnlineCommunicationViewModel::class.java
    override val isFragmentActivity: Boolean = false
        //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_online_communication)

        var list= listOf<String>("高等数学","大学物理","线性代数")
        var data = listOf<Float>(60.toFloat(),38.toFloat(),40.toFloat())
        fre.bindData(list,data)
    }
}
