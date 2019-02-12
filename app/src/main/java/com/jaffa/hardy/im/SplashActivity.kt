package com.jaffa.hardy.im

import android.os.Handler
import com.jaffa.hardy.im.contract.SplashContract
import com.jaffa.hardy.im.presenter.SplashActivityPresenter
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity(),SplashContract.View {

    override fun getlayoutResId(): Int = R.layout.activity_splash

    val presenter = SplashActivityPresenter(this)

    val handler by lazy { Handler() }

    companion object {
       const val DELAY = 2000L
    }

    init {
        presenter.checkLoginStatus()
    }


    //登录后UI的处理
    override fun onNotLoggedIn() {
        handler.postDelayed({
            startActivity<LoginActivity>()
            finish()
        }, DELAY)
    }


    //没有登录UI的处理
    override fun onLoggedIn() {
        startActivity<MainActivity>()
        finish()
    }

}