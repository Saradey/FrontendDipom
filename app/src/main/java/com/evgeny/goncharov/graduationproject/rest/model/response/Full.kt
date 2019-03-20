package com.evgeny.goncharov.graduationproject.rest.model.response

import com.google.gson.annotations.SerializedName

class Full<T>{

    @SerializedName("response")
    var response : T? = null

}