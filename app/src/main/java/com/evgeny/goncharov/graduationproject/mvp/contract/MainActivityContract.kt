package com.evgeny.goncharov.graduationproject.mvp.contract

interface MainActivityContract {

    interface MainPresenter{
        fun logout()

        fun goToTheAuthentication()
    }


    interface MainView{

    }

}