package com.evgeny.goncharov.graduationproject.ui.adapters.source

import android.annotation.SuppressLint
import android.arch.paging.PositionalDataSource
import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import com.evgeny.goncharov.graduationproject.mvp.contract.WallUserContract


/**
 * Created by Evgeny Goncharov on 2019-04-01.
 * jtgn@yandex.ru
 */


@SuppressLint("CheckResult")
class PositionalDataSourceWallUser(val presenter: WallUserContract.WallUserPresenter) :
    PositionalDataSource<ArticleView>() {


    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ArticleView>) {
        //empty
    }


    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ArticleView>) {
        presenter.loadArticleForUser().subscribe({
            callback.onResult(it, 0)
        }, {
            it.printStackTrace()
        })
    }


}