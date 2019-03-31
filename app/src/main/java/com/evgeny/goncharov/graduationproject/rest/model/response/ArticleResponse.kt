package com.evgeny.goncharov.graduationproject.rest.model.response

import com.evgeny.goncharov.graduationproject.model.model.Article
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Evgeny Goncharov on 2019-03-29.
 * jtgn@yandex.ru
 */


class ArticleResponse {

    @SerializedName("list")
    @Expose
    var list = mutableListOf<Article>()

}