package com.evgeny.goncharov.graduationproject.rest.model.request

import com.evgeny.goncharov.graduationproject.consts.API_LOGIN
import com.evgeny.goncharov.graduationproject.consts.API_MAIL
import com.evgeny.goncharov.graduationproject.consts.API_PASSWORD

class RegistrationRequest (val log : String,
                           val pas : String,
                           val email : String): BaseRequestModel(){


    override fun onMaoCreate(map: MutableMap<String, String>) {
        map[API_LOGIN] = log
        map[API_PASSWORD] = pas
        map[API_MAIL] = email
    }


}