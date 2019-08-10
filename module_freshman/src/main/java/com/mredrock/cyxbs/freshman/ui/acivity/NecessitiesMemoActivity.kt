package com.mredrock.cyxbs.freshman.ui.acivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.event.MemoEvet
import kotlinx.android.synthetic.main.freshman_activity_necessities_memo.*
import org.greenrobot.eventbus.EventBus

class NecessitiesMemoActivity : BaseActivity() {
    override val isFragmentActivity: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_necessities_memo)
        tv_memo_cancel.setOnClickListener {
            finish()
        }
        tv_memo_save.setOnClickListener {

            EventBus.getDefault().post(MemoEvet(et_memo_edit.text.toString()))
            finish()
        }
        et_memo_edit.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().toCharArray().isNotEmpty()) {
                    tv_memo_save.visibility = View.VISIBLE
                } else {
                    tv_memo_save.visibility = View.GONE

                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }
}
