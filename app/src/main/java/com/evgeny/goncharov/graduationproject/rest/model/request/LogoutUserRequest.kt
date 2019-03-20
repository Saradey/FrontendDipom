package com.evgeny.goncharov.graduationproject.rest.model.request

import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.consts.API_LOGIN
import com.evgeny.goncharov.graduationproject.consts.API_TOKEN

class LogoutUserRequest : BaseRequestModel(){

    override fun onMaoCreate(map: MutableMap<String, String>) {
        map[API_TOKEN] = CurrentUser.token
        map[API_LOGIN] = CurrentUser.login
    }

}