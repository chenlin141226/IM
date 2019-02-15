package com.jaffa.hardy.im.ui.fragment

import android.content.Intent
import com.hyphenate.chat.EMClient
import com.jaffa.hardy.im.R
import kotlinx.android.synthetic.main.fragment_dynamic.*
import kotlinx.android.synthetic.main.header.*
import com.jaffa.hardy.im.adapter.EMCallBackAdapter
import com.jaffa.hardy.im.ui.activity.LoginActivity
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class DynamicFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_dynamic

    override fun init() {
        super.init()
        headerTitle.text = getString(R.string.dynamic)
        val logoutString = String.format(getString(R.string.logout), EMClient.getInstance().currentUser)
        logout.text = logoutString

        //退出登陆
        logout.setOnClickListener {
            logout()
        }
    }

    fun logout() {
        EMClient.getInstance().logout(true, object : EMCallBackAdapter() {
            override fun onSuccess() {
                super.onSuccess()

                //要在主线程toast
                context?.runOnUiThread {
                    toast(R.string.logout_success)
                    context?.startActivity<LoginActivity>()
                    activity?.finish()
                }
            }

            override fun onError(p0: Int, p1: String?) {
                super.onError(p0, p1)
                context?.runOnUiThread {
                    toast(R.string.logout_failed)
                }
            }
        })
    }
}