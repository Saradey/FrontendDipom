package com.evgeny.goncharov.graduationproject.rest.model.request

import com.evgeny.goncharov.graduationproject.consts.API_KEY
import com.evgeny.goncharov.graduationproject.consts.API_KEY_NAME

abstract class BaseRequestModel {

    fun toRequest() : Map<String, String>{
        val map = mutableMapOf<String, String>()
        map.put(API_KEY_NAME, API_KEY)
        onMaoCreate(map)
        return map
    }


    abstract fun onMaoCreate(map : MutableMap<String, String>)


}