package com.jaffa.hardy.im.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jaffa.hardy.im.R
import com.jaffa.hardy.im.adapter.ContactListAdapter
import com.jaffa.hardy.im.contract.ContactContract
import com.jaffa.hardy.im.presenter.ContactPresenter
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.header.*
import org.jetbrains.anko.forEachChildWithIndex

class ContactFragment : BaseFragment(),ContactContract.View{

    val presenter by lazy { ContactPresenter(this) }

    override fun getLayoutResId(): Int = R.layout.fragment_contacts

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.contact)
        add.visibility = View.VISIBLE

        //apply写法
        swipeRefreshLayout.apply {
            setColorSchemeColors(Color.BLUE)
            isRefreshing = true
            setOnRefreshListener {
                presenter.onLoadContacts()
            }
        }
        swipeRefreshLayout.refreshDrawableState()

        recyclerView.apply {
            //当条目数据发生变化时，会优化
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ContactListAdapter(context)
        }
    }

    override fun onLoadContactsSuccess() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onLoadContactsFailed() {
        swipeRefreshLayout.isRefreshing = false
        recyclerView.adapter?.notifyDataSetChanged()
    }
}