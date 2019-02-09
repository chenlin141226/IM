package com.jaffa.hardy.im.activity

import android.os.Handler
import com.jaffa.hardy.im.R
import com.jaffa.hardy.im.contract.SplashContract
import com.jaffa.hardy.im.presenter.SplashPresenter
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity(),SplashContract.View {

    var presenter = SplashPresenter(this)
    private val handler by lazy { Handler() }

    override fun getlayoutResId(): Int = R.layout.activity_splash

    companion object {
        const val DELAY = 2000L
    }

    override fun init() {
        super.init()
        presenter.checkLoginStatus()
    }

    //登录后UI的处理
    override fun onLoggedIn() {
        startActivity<MainActivity>()
        finish()
    }

    //没有登录UI的处理
    override fun onNotLoggedIn() {
        //延迟2秒跳转登录界面
        handler.postDelayed({
            startActivity<LoginActivity>()
            finish()
        },DELAY)
    }

}