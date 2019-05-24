package com.evgeny.goncharov.graduationproject.mvp.contract

import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import io.reactivex.Single


/**
 * Created by Evgeny Goncharov on 2019-04-01.
 * jtgn@yandex.ru
 */


interface WallUserContract {


    interface WallUserPresenter {

        fun loadArticleForUser() : Single<List<ArticleView>>

    }


    interface WallUserView {

    }


}