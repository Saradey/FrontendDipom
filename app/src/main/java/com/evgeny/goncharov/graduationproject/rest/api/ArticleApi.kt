package com.evgeny.goncharov.graduationproject.rest.api

import com.evgeny.goncharov.graduationproject.consts.ARTICLE_CREATE
import com.evgeny.goncharov.graduationproject.consts.ARTICLE_GET_FOR_USER
import com.evgeny.goncharov.graduationproject.consts.ARTICLE_GET_LAST_ARTICLE
import com.evgeny.goncharov.graduationproject.consts.ARTICLE_GET_OFFSET
import com.evgeny.goncharov.graduationproject.rest.model.request.post.RequestCreateArticle
import com.evgeny.goncharov.graduationproject.rest.model.response.ArticleResponse
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import com.evgeny.goncharov.graduationproject.rest.model.response.Response
import io.reactivex.Observable
import retrofit2.http.*


/**
 * Created by Evgeny Goncharov on 2019-03-29.
 * jtgn@yandex.ru
 */


interface ArticleApi {

    @GET(ARTICLE_GET_LAST_ARTICLE)
    fun getLastArticle(
        @Header("Authorization") namePass: String,
        @QueryMap query: Map<String, String>
    ): Observable<Full<ArticleResponse>>


    @GET(ARTICLE_GET_OFFSET)
    fun getArticleOffset(
        @Header("Authorization") namePass: String,
        @QueryMap query: Map<String, String>
    ): Observable<Full<ArticleResponse>>


    @POST(ARTICLE_CREATE)
    fun createArticle(
        @Header("Authorization") namePass: String,
        @Body body : RequestCreateArticle
    ): Observable<Full<Response>>


    @GET(ARTICLE_GET_FOR_USER)
    fun getForUser(
        @Header("Authorization") namePass: String,
        @QueryMap query: Map<String, String>
    ): Observable<Full<ArticleResponse>>

}