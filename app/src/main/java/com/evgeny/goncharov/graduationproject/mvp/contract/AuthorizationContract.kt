package com.evgeny.goncharov.graduationproject.mvp.contract

import com.evgeny.goncharov.graduationproject.mvp.BaseView

interface AuthorizationContract {


    interface AuthorizationPresenter{
        fun goToTheAuthentication(login: String, password: String)

    }


    interface  AuthorizationView : BaseView {

        fun error()

        fun authenticationDone()

    }


}