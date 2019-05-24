package com.evgeny.goncharov.graduationproject.model.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Evgeny Goncharov on 2019-03-29.
 * jtgn@yandex.ru
 */


class Article {

    @SerializedName("id")
    @Expose
    var id : Int = -1

    @SerializedName("text")
    @Expose
    var text : String = "null"

    @SerializedName("nameArticle")
    @Expose
    var nameArticle : String = "null"

    @SerializedName("id_user")
    @Expose
    var idUser : String = "null"

}