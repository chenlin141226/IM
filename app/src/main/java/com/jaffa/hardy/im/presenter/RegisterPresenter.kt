package com.jaffa.hardy.im.presenter

import cn.bmob.v3.BmobUser
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import com.jaffa.hardy.im.contract.RegisterContract
import com.jaffa.hardy.im.extentions.isValidPassword
import com.jaffa.hardy.im.extentions.isValidUserName

class RegisterPresenter(val view : RegisterContract.View) : RegisterContract.Presenter {

    override fun register(userName: String, password: String, confirmPassword : String) {
        if(userName.isValidUserName()){
            if(password.isValidPassword()){
                //确认密码是否一直
                if(password == confirmPassword){
                    //开始注册
                   // view.onStartRegister()
                    //环信注册
                    registerBmob(userName,password)
                }else view.onConfirmPasswordError()
            }else view.onPassworldError()
        }else view.onUserNameError()
    }


    //Bmob云注册
    private fun registerBmob(userName: String, password: String) {
        val bu = BmobUser()
        bu.username = userName
        bu.setPassword(password)

        bu.signUp(object : SaveListener<BmobUser>() {
            override fun done(s: BmobUser?, e: BmobException?) {
                if(e == null){

                }else{
                    //注册失败
                    view.onRegisterFails()
                }
            }
        })

    }
}