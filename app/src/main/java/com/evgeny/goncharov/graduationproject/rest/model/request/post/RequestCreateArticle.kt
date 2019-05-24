package com.evgeny.goncharov.graduationproject.rest.model.request.post


/**
 * Created by Evgeny Goncharov on 2019-05-24.
 * jtgn@yandex.ru
 */


class RequestCreateArticle(
    val nameArticle: String,
    val username: String,
    val textArticle: String
) : RequestPostBase()