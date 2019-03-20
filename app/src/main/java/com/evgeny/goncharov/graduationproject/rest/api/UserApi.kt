package com.evgeny.goncharov.graduationproject.rest.api

import com.evgeny.goncharov.graduationproject.consts.USER_GET
import com.evgeny.goncharov.graduationproject.consts.USER_LOGOUT
import com.evgeny.goncharov.graduationproject.model.model.Token
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface UserApi {

    @GET(USER_GET)
    fun getToken(@QueryMap query : Map<String, String>) : Observable<Full<Token>>

    @GET(USER_LOGOUT)
    fun logout(@QueryMap query : Map<String, String>) : Observable<Void>

}