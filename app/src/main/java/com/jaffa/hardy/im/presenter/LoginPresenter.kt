package com.jaffa.hardy.im.presenter

import com.jaffa.hardy.im.contract.LoginContract
import com.jaffa.hardy.im.extentions.isValidPassword
import com.jaffa.hardy.im.extentions.isValidUserName
import com.hyphenate.chat.EMClient
import com.jaffa.hardy.im.adapter.EMCallBackAdapter


class LoginPresenter(val view : LoginContract.View) : LoginContract.Presenter {

    override fun login(userName: String, password: String) {

        if(userName.isValidUserName()){
            //用户名合法，继续校验密码
            if(password.isValidPassword()){
                //密码合法，开始登录
                view.StartLogin()
                //环信登录
                LoginEaseMob(userName,password)
            }else view.onPassworldError()
        }else  view.onUserNameError()

    }

    private fun LoginEaseMob(userName: String, password: String) {
        EMClient.getInstance().login(userName, password, object : EMCallBackAdapter() {
            override fun onSuccess() {
                super.onSuccess()
                //登录成功后加载本地会话和群组的load完毕
                EMClient.getInstance().groupManager().loadAllGroups()
                EMClient.getInstance().chatManager().loadAllConversations()

                //登录成功，通知view层更新ui
                uiThread {
                    view.onLoggedInSuccess()
                }
            }

            override fun onError(p0: Int, p1: String?) {
                super.onError(p0, p1)
               uiThread { view.onLoggedInFails() }
            }
        })
    }
}