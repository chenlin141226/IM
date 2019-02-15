package com.jaffa.hardy.im.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jaffa.hardy.im.R
import com.jaffa.hardy.im.adapter.ContactListAdapter
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.header.*

class ContactFragment : BaseFragment(){
    
    override fun getLayoutResId(): Int = R.layout.fragment_contacts

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.contact)
        add.visibility = View.VISIBLE

        //apply写法
        swipeRefreshLayout.apply {
            setColorSchemeColors(Color.BLUE)
            isRefreshing = true
        }

        recyclerView.apply {
            //当条目数据发生变化时，会优化
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ContactListAdapter(context)
        }
    }
}