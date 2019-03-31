package com.evgeny.goncharov.graduationproject.rest.api

import com.evgeny.goncharov.graduationproject.consts.ARTICLE_GET_LAST_ARTICLE
import com.evgeny.goncharov.graduationproject.consts.ARTICLE_GET_OFFSET
import com.evgeny.goncharov.graduationproject.model.model.Article
import com.evgeny.goncharov.graduationproject.rest.model.response.ArticleResponse
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap
import java.util.*


/**
 * Created by Evgeny Goncharov on 2019-03-29.
 * jtgn@yandex.ru
 */


interface ArticleApi {

    @GET(ARTICLE_GET_LAST_ARTICLE)
    fun getLastArticle(@QueryMap query : Map<String, String>) : Observable<Full<ArticleResponse>>

    @GET(ARTICLE_GET_OFFSET)
    fun getArticleOffset(@QueryMap query : Map<String, String>) : Observable<Full<ArticleResponse>>

}