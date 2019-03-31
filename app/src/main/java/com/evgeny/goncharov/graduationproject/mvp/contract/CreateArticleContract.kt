package com.evgeny.goncharov.graduationproject.mvp.contract


/**
 * Created by Evgeny Goncharov on 2019-03-31.
 * jtgn@yandex.ru
 */


interface CreateArticleContract {

    interface CreateArticlePresenter {

        fun loadArticleToServer(text : String, name : String)

    }

    interface CreateArticleView {

        fun success()

        fun filed()

    }

}