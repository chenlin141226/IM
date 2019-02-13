package com.jaffa.hardy.im

import com.jaffa.hardy.im.contract.LoginContract
import com.jaffa.hardy.im.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity(),LoginContract.View{

    override fun getlayoutResId(): Int = R.layout.activity_login

    val presenter by lazy { LoginPresenter(this) }

    override fun init() {
        super.init()
        login.setOnClickListener {login()}
        login.setOnEditorActionListener { p0, p1, p2 ->
            login()
            true
        }
    }

    fun login(){
        val userName = userName.text.trim().toString()
        val password = password.text.trim().toString()
        presenter.login(userName,password)
    }

    override fun onUserNameError() {
        userName.error = getString(R.string.user_name_error)
    }

    override fun onPassworldError() {
        password.error = getString(R.string.password_error)
    }

    override fun StartLogin() {
        //弹出进度条
        showProgress(getString(R.string.logging))
    }

    override fun onLoggedInSuccess() {
         //隐藏进度条
        dismissProgress()
        //进入主界面
        startActivity<MainActivity>()
        //推出loginActivity
        finish()
    }

    override fun onLoggedInFails() {
        //隐藏进度条
        dismissProgress()
        //显示错误提示
        toast(getString(R.string.login_failed))
    }

}