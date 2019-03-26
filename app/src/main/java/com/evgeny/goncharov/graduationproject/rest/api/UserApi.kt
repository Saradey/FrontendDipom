package com.evgeny.goncharov.graduationproject.rest.api

import com.evgeny.goncharov.graduationproject.consts.USER_GET
import com.evgeny.goncharov.graduationproject.consts.USER_LOGOUT
import com.evgeny.goncharov.graduationproject.consts.USER_REGISTRATION
import com.evgeny.goncharov.graduationproject.rest.model.response.Token
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import com.evgeny.goncharov.graduationproject.rest.model.response.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface UserApi {

    @GET(USER_GET)
    fun getToken(@QueryMap query : Map<String, String>) : Observable<Full<Token>>

    @GET(USER_LOGOUT)
    fun logout(@QueryMap query : Map<String, String>) : Observable<Void>

    @GET(USER_REGISTRATION)
    fun registration(@QueryMap query : Map<String, String>) : Observable<Full<Response>>

}