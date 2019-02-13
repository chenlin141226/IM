package com.jaffa.hardy.im

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

abstract class BaseActivity : AppCompatActivity() {

    val progressBar by lazy { ProgressDialog(this) }
    val inputMethodManager by lazy { getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager }

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

    //隐藏软键盘
    fun hideSofeKeyboard(){
        inputMethodManager.hideSoftInputFromWindow(currentFocus.windowToken,0)
    }
}