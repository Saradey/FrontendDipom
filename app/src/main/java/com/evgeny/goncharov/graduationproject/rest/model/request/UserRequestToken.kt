package com.evgeny.goncharov.graduationproject.rest.model.request

import com.evgeny.goncharov.graduationproject.consts.API_LOGIN
import com.evgeny.goncharov.graduationproject.consts.API_PASSWORD

class UserRequestToken constructor(private val login: String,
                                   private val password: String) : BaseRequestModel() {


    override fun onMaoCreate(map: MutableMap<String, String>) {
        map[API_LOGIN] = login
        map[API_PASSWORD] = password
    }


}