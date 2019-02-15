package com.jaffa.hardy.im.contract

interface ContactContract {

    interface  Presenter : BasePresenter{

        fun onLoadContacts()

    }

    interface View {
       fun onLoadContactsSuccess()
       fun onLoadContactsFailed()
    }
}