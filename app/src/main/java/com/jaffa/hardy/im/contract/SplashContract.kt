package com.jaffa.hardy.im.contract

interface SplashContract {
    interface Presenter : BasePresenter{

    }

    interface View {
         fun onNotLoggedIn();
         fun onLoggedIn();
    }
}