package com.evgeny.goncharov.graduationproject.rest.model.request

import com.evgeny.goncharov.graduationproject.consts.API_OFFSET


/**
 * Created by Evgeny Goncharov on 2019-03-31.
 * jtgn@yandex.ru
 */
 

class OffsetArticleRequestModel(private val offset : String) : BaseRequestModel(){


    override fun onMaoCreate(map: MutableMap<String, String>) {
        map[API_OFFSET] = offset
    }


}