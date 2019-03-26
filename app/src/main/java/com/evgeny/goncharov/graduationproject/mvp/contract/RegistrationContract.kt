package com.evgeny.goncharov.graduationproject.mvp.contract

interface RegistrationContract {

    interface RegistrationPresenter{

        fun requestRegistration(log: String, pas: String, email: String)

    }


    interface RegistrationView {

        fun registrationOk()

        fun errorRegistration()

    }

}