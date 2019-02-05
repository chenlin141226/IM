package com.jaffa.hardy.im

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getlayoutResId())
        init()
    }

    private fun init() {

    }

    abstract fun getlayoutResId() :Int
}