package com.jaffa.hardy.im.presenter

import com.jaffa.hardy.im.contract.ContactContract
import com.hyphenate.chat.EMClient
import com.hyphenate.exceptions.HyphenateException
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class ContactPresenter(val view : ContactContract.View) : ContactContract.Presenter {


    override fun onLoadContacts() {
        try {

            doAsync {
                val usernames = EMClient.getInstance().contactManager().allContactsFromServer
                uiThread { view.onLoadContactsSuccess() }
            }

        }catch (e: HyphenateException){
            view.onLoadContactsFailed()
        }

    }
}