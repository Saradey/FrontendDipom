package com.evgeny.goncharov.graduationproject.ui.adapters.source

import android.annotation.SuppressLint
import android.arch.paging.PositionalDataSource
import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import com.evgeny.goncharov.graduationproject.mvp.contract.WallAllContract


/**
 * Created by Evgeny Goncharov on 2019-03-28.
 * jtgn@yandex.ru
 */

@SuppressLint("CheckResult")
class PositionalDataSourceWallAll(private val presenter: WallAllContract.WallAllPresenter) :
    PositionalDataSource<ArticleView>() {


    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ArticleView>) {
        presenter.loadLastData().subscribe({
            callback.onResult(it, 0)
        }, {
            it.printStackTrace()
        })
    }


    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ArticleView>) {
        presenter.loadDataOffset().subscribe({
            callback.onResult(it)
        }, {
            it.printStackTrace()
        })
    }


}