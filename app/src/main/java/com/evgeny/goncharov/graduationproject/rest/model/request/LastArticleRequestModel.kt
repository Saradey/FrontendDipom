package com.evgeny.goncharov.graduationproject.rest.model.request

import com.evgeny.goncharov.graduationproject.consts.API_LOGIN
import com.evgeny.goncharov.graduationproject.consts.API_TOKEN


/**
 * Created by Evgeny Goncharov on 2019-03-29.
 * jtgn@yandex.ru
 */
 

class LastArticleRequestModel(private val login : String, private val token : String) : BaseRequestModel() {

    override fun onMaoCreate(map: MutableMap<String, String>) {
        map[API_LOGIN] = login
        map[API_TOKEN] = token
    }

}