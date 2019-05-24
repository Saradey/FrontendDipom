package com.evgeny.goncharov.graduationproject.rest.model.request.post


/**
 * Created by Evgeny Goncharov on 2019-05-23.
 * jtgn@yandex.ru
 */


class RequestRegistrationBody(
    val name: String,
    val password: String,
    val email: String
) : RequestPostBase()