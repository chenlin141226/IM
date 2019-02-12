package com.jaffa.hardy.im.presenter

import com.hyphenate.chat.EMClient
import com.jaffa.hardy.im.contract.SplashContract

class SplashActivityPresenter(val view : SplashContract.View) : SplashContract.Presenter {

    override fun checkLoginStatus() {
        if(isLogin()) view.onLoggedIn() else view.onNotLoggedIn()
    }

    private fun isLogin(): Boolean  = EMClient.getInstance().isConnected&&EMClient.getInstance().isLoggedInBefore
}