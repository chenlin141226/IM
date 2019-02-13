package com.jaffa.hardy.im.contract

interface  RegisterContract {
    interface Presenter : BasePresenter{
        fun register(userName : String , password : String)
    }

    interface View {
        fun onUserNameError()
        fun onPassworldError()
        fun onConfirmPasswordError()
        fun StartRegister()
        fun onRegisterInSuccess()
        fun onRegisterFails()
    }
}