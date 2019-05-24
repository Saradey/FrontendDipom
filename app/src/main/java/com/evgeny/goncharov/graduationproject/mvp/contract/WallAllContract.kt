package com.evgeny.goncharov.graduationproject.mvp.contract

import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import io.reactivex.Single

interface WallAllContract {


    interface WallAllPresenter {

        fun loadLastData(): Single<List<ArticleView>>

        fun loadDataOffset() : Single<List<ArticleView>>

    }


    interface WallAllView {

    }


}