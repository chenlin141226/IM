package com.jaffa.hardy.im.ui.activity

import android.Manifest
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import com.jaffa.hardy.im.R
import com.jaffa.hardy.im.contract.LoginContract
import com.jaffa.hardy.im.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity(),LoginContract.View{

    override fun getlayoutResId(): Int = R.layout.activity_login

    private val presenter by lazy { LoginPresenter(this) }

    override fun init() {
        super.init()
        newUser.setOnClickListener { startActivity<RegisterActivity>() }
        login.setOnClickListener {login()}
        login.setOnEditorActionListener { p0, p1, p2 ->
            login()
            true
        }
    }

    fun login(){
        //隐藏软键盘
        hideSofeKeyboard()

        //检查权限
        if(hasWriteExternalStoragePermission()){
            val userName = userName.text.trim().toString()
            val password = password.text.trim().toString()
            presenter.login(userName,password)
        }else applyriteExternalStoragePermission()

    }

    /**
     * 申请权限
     */
    private fun applyriteExternalStoragePermission() {
        val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(this,permissions,0)
    }

    /**
     * 检查是否有权限
     */
    private fun hasWriteExternalStoragePermission(): Boolean {
        val result = ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return result == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            //用户同意开始登录
            login()
        }else toast(getString(R.string.permission_denied))
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