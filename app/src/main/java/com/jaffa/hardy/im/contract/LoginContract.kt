package com.jaffa.hardy.im.contract

interface LoginContract {

    interface Presenter : BasePresenter {
         fun login(userName : String , password : String)
    }

    interface  View {
        fun onUserNameError()
        fun onPassworldError()
        fun StartLogin()
        fun onLoggedInSuccess()
        fun onLoggedInFails()
    }
}