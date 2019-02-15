package com.jaffa.hardy.im

import com.jaffa.hardy.im.contract.RegisterContract
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseActivity(),RegisterContract.View {

    override fun getlayoutResId(): Int = R.layout.activity_register

    override fun onUserNameError() {
        userName.error = getString(R.string.user_name_error)
    }

    override fun onPassworldError() {
        password.error = getString(R.string.password_error)
    }

    override fun onConfirmPasswordError() {
        password.error = getString(R.string.confirm_password_error)
    }

    override fun onStartRegister() {
        showProgress(getString(R.string.registering))
    }

    override fun onRegisterInSuccess() {

        //进入登录界面
    }

    override fun onRegisterFails() {
        dismissProgress()
        toast(R.string.register_failed)
    }

}