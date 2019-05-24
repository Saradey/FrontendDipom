package com.evgeny.goncharov.graduationproject.rest.model.request

import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.consts.API_LOGIN


/**
 * Created by Evgeny Goncharov on 2019-04-01.
 * jtgn@yandex.ru
 */


class GetForUserRequest : BaseRequestModel(){


    override fun onMaoCreate(map: MutableMap<String, String>) {
        map[API_LOGIN] = CurrentUser.username
    }


}