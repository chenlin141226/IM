package com.jaffa.hardy.im

import com.jaffa.hardy.im.contract.SplashContract

class SplashActivity : BaseActivity(),SplashContract.View {

    override fun getlayoutResId(): Int = R.layout.activity_splash

    //登录后UI的处理
    override fun onLoggedIn() {
    }

    //没有登录UI的处理
    override fun onNotLoggedIn() {
    }

}