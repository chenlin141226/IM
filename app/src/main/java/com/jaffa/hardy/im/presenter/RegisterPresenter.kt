package com.jaffa.hardy.im.presenter

import com.jaffa.hardy.im.contract.RegisterContract
import com.jaffa.hardy.im.extentions.isValidPassword
import com.jaffa.hardy.im.extentions.isValidUserName

class RegisterPresenter(val view : RegisterContract.View) : RegisterContract.Presenter {

    override fun register(userName: String, password: String, confirmPassword : String) {
        if(userName.isValidUserName()){
            if(password.isValidPassword()){
                //确认密码是否一直
                if(password.equals(confirmPassword)){
                    //开始注册
                    view.onStartRegister()
                    //环信注册

                }else view.onConfirmPasswordError()
            }else view.onPassworldError()
        }else view.onUserNameError()
    }
}