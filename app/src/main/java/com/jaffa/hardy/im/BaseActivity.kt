package com.jaffa.hardy.im

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window

abstract class BaseActivity : AppCompatActivity() {

    val progressBar by lazy { ProgressDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getlayoutResId())
        init()
    }

    open fun init() {

    }

    abstract fun getlayoutResId() :Int

    fun showProgress(message:String){
        progressBar.setMessage(message)
        progressBar.show()
    }

    fun dismissProgress(){
        progressBar.dismiss()
    }

}