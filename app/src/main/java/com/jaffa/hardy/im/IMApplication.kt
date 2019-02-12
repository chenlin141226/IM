package com.jaffa.hardy.im

import android.app.Application
import com.hyphenate.chat.EMClient
import com.hyphenate.chat.EMOptions



class IMApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val options = EMOptions()
        options.setAutoTransferMessageAttachments(true);
        //初始化
        EMClient.getInstance().init(applicationContext, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(BuildConfig.DEBUG);
    }
}