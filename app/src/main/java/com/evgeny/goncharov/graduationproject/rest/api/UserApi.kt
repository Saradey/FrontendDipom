package com.evgeny.goncharov.graduationproject.rest.api

import com.evgeny.goncharov.graduationproject.consts.USER_AUTHENTICATION
import com.evgeny.goncharov.graduationproject.consts.USER_REGISTRATION
import com.evgeny.goncharov.graduationproject.rest.model.request.post.RequestAuthorizationBody
import com.evgeny.goncharov.graduationproject.rest.model.request.post.RequestRegistrationBody
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import com.evgeny.goncharov.graduationproject.rest.model.response.Response
import io.reactivex.Observable
import retrofit2.http.*

interface UserApi {

    @POST(USER_AUTHENTICATION)
    fun authorization(
        @Header("Authorization") namePassword: String,
        @Body body: RequestAuthorizationBody
    ): Observable<Full<Response>>


//    @GET(USER_LOGOUT)
//    fun logout(
//        @Header("Authorization") namePass: String,
//        @QueryMap query: Map<String, String>
//    ): Observable<Void>


    @POST(USER_REGISTRATION)
    fun registration(
        @Body body: RequestRegistrationBody
    ): Observable<Full<Response>>

}