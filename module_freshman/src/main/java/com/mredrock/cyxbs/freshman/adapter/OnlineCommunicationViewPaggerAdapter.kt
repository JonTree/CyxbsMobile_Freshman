package com.mredrock.cyxbs.freshman.adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.data.bean.GroupHomeBean
import com.mredrock.cyxbs.freshman.data.bean.GroupStudentBean
import com.mredrock.cyxbs.freshman.util.apiService
import kotlinx.android.synthetic.main.freshman_view_pager_group_page.view.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.view.KeyEvent
import android.widget.EditText
import com.mredrock.cyxbs.freshman.data.bean.OnlineActivitiesBean
import com.mredrock.cyxbs.freshman.ui.acivity.OnlineCommunicationActivity
import kotlinx.android.synthetic.main.freshman_view_pager_page_online_activity.view.*


/**
 * Created by Tree on 2019/8/11 1:09
 */
class OnlineCommunicationViewPaggerAdapter(val context: Context) : PagerAdapter() {

    val titleList = listOf("学院群", "老乡群", "线上活动")
    val pageList = mutableListOf<View>()

    init {
        pageList.add(
            View.inflate(
                context,
                com.mredrock.cyxbs.freshman.R.layout.freshman_view_pager_group_page, null
            )
        )
        pageList.add(
            View.inflate(
                context,
                com.mredrock.cyxbs.freshman.R.layout.freshman_view_pager_group_page, null
            )
        )

        pageList.add(
            View.inflate(
                context,
                com.mredrock.cyxbs.freshman.R.layout.freshman_view_pager_page_online_activity, null
            )
        )
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(pageList[position])
        return pageList[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(pageList[position])
    }


    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    fun initPager1(groupBean: GroupStudentBean) {
        pageList[0].apply {
            recycle_view_group_search.layoutManager = LinearLayoutManager(context)
            val adapter = OnlineGroupSearchRecycleViewAdapter()
            recycle_view_group_search.adapter = adapter
            recycle_view_group.setOnTouchListener { _, _ -> adapter.updata(null)
            false}
            et_group.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    fuzzySearch1(et_group){
                        if (it.text == null) {
                            if (s.toString().toCharArray().isEmpty()) {
                                recycle_view_group.adapter = OnlineGroupStudentRecycleViewAdapter(groupBean,context)
                            }
                            adapter.updata(null)
                        } else {
                            adapter.updata(it)
                        }
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
            et_group.setOnEditorActionListener(object : TextView.OnEditorActionListener {
                override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        adapter.updata(null)
                        fuzzySearch1(et_group){
                            if (it.text == null) {
                                et_group.text.clear()
                                et_group.hint = "暂时没有你想要的群号"
                            } else {
                                recycle_view_group.adapter = OnlineGroupStudentRecycleViewAdapter(it,context)
                            }
                        }
                        return true
                    }
                    return false
                }
            })
            recycle_view_group.layoutManager = LinearLayoutManager(context)
            recycle_view_group.adapter = OnlineGroupStudentRecycleViewAdapter(groupBean,context)
        }
    }


    fun initPager2(groupBean: GroupHomeBean) {
        pageList[1].apply {
            recycle_view_group_search.layoutManager = LinearLayoutManager(context)
            val adapter = OnlineGroupSearchRecycleViewAdapter()
            recycle_view_group_search.adapter = adapter
            recycle_view_group.setOnTouchListener { _, _ -> adapter.updata(null)
                false}
            et_group.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    fuzzySearch2(et_group){
                        if (it.text == null) {
                            if (s.toString().toCharArray().isEmpty()) {
                                recycle_view_group.adapter = OnlineGroupHomeRecycleViewAdapter(groupBean,context)
                            }
                            adapter.updata(null)
                        } else {
                            adapter.updata(it)
                        }
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
            et_group.setOnEditorActionListener(object : TextView.OnEditorActionListener {
                override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        adapter.updata(null)
                        fuzzySearch2(et_group){
                            if (it.text == null) {
                                et_group.text.clear()
                                et_group.hint = "暂时没有你想要的群号"
                            } else {
                                recycle_view_group.adapter = OnlineGroupStudentRecycleViewAdapter(it,context)
                            }
                        }
                        return true
                    }
                    return false
                }
            })
            recycle_view_group.layoutManager = LinearLayoutManager(context)
            recycle_view_group.adapter = OnlineGroupHomeRecycleViewAdapter(groupBean,context)
        }
    }



    fun initPager3(bean: OnlineActivitiesBean) {
        pageList[2].apply {
            recycle_view_online_activity.layoutManager = LinearLayoutManager(context)
            recycle_view_online_activity.adapter = OnlineActivityRecycleViewAdapter(bean)
        }
    }



    fun fuzzySearch1(et_group: EditText,funtion: (GroupStudentBean) -> Unit) {
        apiService.getGroupCollegeSearch(RequestBody.create(null,et_group.text.toString())).enqueue(object : retrofit2.Callback<GroupStudentBean>{
            override fun onResponse(call: Call<GroupStudentBean>, response: Response<GroupStudentBean>) {
                response.body()?.let { funtion(it) }
            }
            override fun onFailure(call: Call<GroupStudentBean>, t: Throwable) {
            }
        })
    }

    fun fuzzySearch2(et_group: EditText,funtion: (GroupStudentBean) -> Unit) {
        apiService.getGroupProvinceSearch(RequestBody.create(null,et_group.text.toString())).enqueue(object : retrofit2.Callback<GroupStudentBean>{
            override fun onResponse(call: Call<GroupStudentBean>, response: Response<GroupStudentBean>) {
                response.body()?.let { funtion(it) }
            }
            override fun onFailure(call: Call<GroupStudentBean>, t: Throwable) {
            }
        })
    }

}
