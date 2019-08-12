package com.mredrock.cyxbs.freshman.ui.acivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapter.EditRecyclerViewAdapter
import com.mredrock.cyxbs.freshman.data.bean.NecessityBean
import kotlinx.android.synthetic.main.freshman_activity_edit.*
import org.greenrobot.eventbus.Subscribe

class EditActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false


    lateinit var memo:NecessityBean.TextBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_edit)
        tv_edit_cancel.setOnClickListener {
            finish()
        }
        memo = intent.getSerializableExtra("memo") as NecessityBean.TextBean
        if (memo.data.isEmpty()) {
            ll_tip.visibility = View.VISIBLE
        }
        ll_tip.setOnClickListener {
            startActivity<NecessitiesMemoActivity>(true,"memo" to memo)
        }
        rv_edit.layoutManager = LinearLayoutManager(this)
        rv_edit.adapter = EditRecyclerViewAdapter(tv_edit_delete,memo)
        tv_tip_tiltle.setOnClickListener {
            val intent = Intent(this, NecessitiesMemoActivity::class.java)
            startActivity(intent)
        }
    }

}
