package com.jaffa.hardy.im.contract

interface  RegisterContract {
    interface Presenter : BasePresenter{
        fun register(userName : String , password : String,confirmPassword : String)
    }

    interface View {
        fun onUserNameError()
        fun onPassworldError()
        fun onConfirmPasswordError()
        fun onStartRegister()
        fun onRegisterInSuccess()
        fun onRegisterFails()
        fun onUserExit()
    }
}