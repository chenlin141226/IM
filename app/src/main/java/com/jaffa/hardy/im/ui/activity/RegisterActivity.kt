package com.jaffa.hardy.im.ui.activity

import com.jaffa.hardy.im.R
import com.jaffa.hardy.im.contract.RegisterContract
import com.jaffa.hardy.im.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseActivity(),RegisterContract.View {

    private val presenter by lazy { RegisterPresenter(this) }

    override fun getlayoutResId(): Int = R.layout.activity_register

    override fun init() {
        super.init()
      register.setOnClickListener { register() }
      register.setOnEditorActionListener { p0, p1, p2 ->
          register()
          true
      }
    }

    fun register(){

        //隐藏软键盘
        hideSofeKeyboard()

        val username = r_userName.text.trim().toString()
        val password = r_password.text.trim().toString()
        val confirmPassword = confirmPassword.text.trim().toString()
        presenter.register(username,password,confirmPassword)
    }

    override fun onUserNameError() {
        r_userName.error = getString(R.string.user_name_error)
    }

    override fun onPassworldError() {
        r_password.error = getString(R.string.password_error)
    }

    override fun onConfirmPasswordError() {
        confirmPassword.error = getString(R.string.confirm_password_error)
    }

    override fun onStartRegister() {
        showProgress(getString(R.string.registering))
    }

    override fun onRegisterInSuccess() {
       dismissProgress()
        toast(R.string.register_success)
        //进入登录界面
        finish()

    }

    override fun onUserExit() {
        dismissProgress()
        toast(R.string.user_already_exist)
    }

    override fun onRegisterFails() {
        dismissProgress()
        toast(R.string.register_failed)
    }

}