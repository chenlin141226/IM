package com.jaffa.hardy.im.adapter

import com.hyphenate.EMCallBack
//适配器模式
open class EMCallBackAdapter : EMCallBack {
    override fun onSuccess() {
    }

    override fun onProgress(p0: Int, p1: String?) {
    }

    override fun onError(p0: Int, p1: String?) {
    }
}