package com.evgeny.goncharov.graduationproject.rest.model.request

import com.evgeny.goncharov.graduationproject.consts.API_NAME_ARTICLE
import com.evgeny.goncharov.graduationproject.consts.API_TEXT_ARTICLE


/**
 * Created by Evgeny Goncharov on 2019-03-31.
 * jtgn@yandex.ru
 */
 

class CreateArticleRequestModel(private val text : String, private val name : String) : BaseRequestModel(){


    override fun onMaoCreate(map: MutableMap<String, String>) {
        map[API_TEXT_ARTICLE] = text
        map[API_NAME_ARTICLE]= name
    }


}