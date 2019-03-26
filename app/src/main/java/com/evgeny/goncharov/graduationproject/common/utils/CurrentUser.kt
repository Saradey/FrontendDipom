package com.evgeny.goncharov.graduationproject.common.utils

class CurrentUser{

    companion object {
        var token = ""
        var login = ""
        var password = ""

        fun logout(){
            token = ""
            login = ""
            password = ""
        }

    }


}