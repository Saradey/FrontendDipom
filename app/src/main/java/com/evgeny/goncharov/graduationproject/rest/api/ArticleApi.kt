package com.evgeny.goncharov.graduationproject.rest.api

import com.evgeny.goncharov.graduationproject.consts.ARTICLE_CREATE
import com.evgeny.goncharov.graduationproject.consts.ARTICLE_GET_LAST_ARTICLE
import com.evgeny.goncharov.graduationproject.consts.ARTICLE_GET_OFFSET
import com.evgeny.goncharov.graduationproject.rest.model.response.ArticleResponse
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import com.evgeny.goncharov.graduationproject.rest.model.response.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap


/**
 * Created by Evgeny Goncharov on 2019-03-29.
 * jtgn@yandex.ru
 */


interface ArticleApi {

    @GET(ARTICLE_GET_LAST_ARTICLE)
    fun getLastArticle(@QueryMap query : Map<String, String>) : Observable<Full<ArticleResponse>>

    @GET(ARTICLE_GET_OFFSET)
    fun getArticleOffset(@QueryMap query : Map<String, String>) : Observable<Full<ArticleResponse>>

    @GET(ARTICLE_CREATE)
    fun createArticle(@QueryMap query : Map<String, String>) : Observable<Full<Response>>

}