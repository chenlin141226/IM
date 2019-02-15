package com.jaffa.hardy.im.ui.activity

import com.jaffa.hardy.im.R
import com.jaffa.hardy.im.factory.FragmentFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getlayoutResId(): Int  = R.layout.activity_main

    override fun init() {
        super.init()
        bottomBar.setOnTabSelectListener {
            tabId ->
            val beginTransaction = supportFragmentManager.beginTransaction()
            FragmentFactory.instance.getFragment(tabId)?.let { beginTransaction.replace(R.id.fragment_frame, it) }
            beginTransaction.commit()
        }
    }
}
