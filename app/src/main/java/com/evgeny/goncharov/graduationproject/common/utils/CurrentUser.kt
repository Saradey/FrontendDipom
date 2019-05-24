package com.evgeny.goncharov.graduationproject.common.utils

import com.evgeny.goncharov.graduationproject.security.base.Decoder64
import com.evgeny.goncharov.graduationproject.security.base.Encoder64
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import javax.inject.Inject

class CurrentUser {

    @Inject
    lateinit var decoder64: Decoder64

    @Inject
    lateinit var encoder64: Encoder64


    lateinit var pasNameBase64: String

    companion object {
        lateinit var username: String
    }

    init {
        MainActivity.appComponent.inject(this)
    }


    fun parseStringToBase64(login: String, password: String) {
        username = login
        pasNameBase64 = "Basic ${encoder64.ToBase64("$login:$password")}"
    }


    fun logout() {
        pasNameBase64 = ""
        username = ""
    }
}