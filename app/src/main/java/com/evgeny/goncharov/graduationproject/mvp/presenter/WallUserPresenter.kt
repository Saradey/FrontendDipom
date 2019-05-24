package com.evgeny.goncharov.graduationproject.mvp.presenter

import com.evgeny.goncharov.graduationproject.common.managers.NetworkManager
import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import com.evgeny.goncharov.graduationproject.mvp.contract.WallUserContract
import com.evgeny.goncharov.graduationproject.rest.api.ArticleApi
import com.evgeny.goncharov.graduationproject.rest.model.request.GetForUserRequest
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Evgeny Goncharov on 2019-04-01.
 * jtgn@yandex.ru
 */


class WallUserPresenter(val view: WallUserContract.WallUserView) : WallUserContract.WallUserPresenter {


    @Inject
    lateinit var networkManager: NetworkManager

    @Inject
    lateinit var articleApi: ArticleApi

    @Inject
    lateinit var currentUser: CurrentUser


    init {
        MainActivity.appComponent.inject(this)
    }


    override fun loadArticleForUser(): Single<List<ArticleView>> {
        return networkManager.getNetworkStatus()
            .flatMap {
                when (it) {
                    true -> loadDataFromInternet()
                    false -> loadDataFromDataBase()
                }
            }.toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


    private fun loadDataFromInternet(): Observable<ArticleView> {
        return articleApi.getForUser(
            currentUser.pasNameBase64,
            GetForUserRequest().toRequest()
        ).flatMap {
            Observable.fromIterable(it.response!!.list)
        }.doOnNext {
            //TODO сохранения в базу данных
        }.flatMap {
            val list = mutableListOf<ArticleView>()
            list.add(ArticleView(it))
            Observable.fromIterable(list)
        }
    }


    private fun loadDataFromDataBase(): Observable<ArticleView>? {
        return null
    }

}