package com.evgeny.goncharov.graduationproject.mvp.presenter

import android.annotation.SuppressLint
import com.evgeny.goncharov.graduationproject.common.managers.NetworkManager
import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import com.evgeny.goncharov.graduationproject.mvp.contract.WallAllContract
import com.evgeny.goncharov.graduationproject.rest.api.ArticleApi
import com.evgeny.goncharov.graduationproject.rest.model.request.LastArticleRequestModel
import com.evgeny.goncharov.graduationproject.rest.model.request.OffsetArticleRequestModel
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Evgeny Goncharov on 2019-03-28.
 * jtgn@yandex.ru
 */


class WallAllPresenter(val view: WallAllContract.WallAllView) : WallAllContract.WallAllPresenter {

    @Inject
    lateinit var networkManager: NetworkManager

    @Inject
    lateinit var articleApi: ArticleApi

    private var getIdOffset = -1


    init {
        MainActivity.appComponent.inject(this)
    }


    @SuppressLint("CheckResult")
    override fun loadLastData(): Single<List<ArticleView>> {
        return networkManager.getNetworkStatus()
            .flatMap {
                when (it) {
                    true -> onLoadLastDataFromInternet()
                    false -> onLoadDataFromDatabase()
                }
            }.toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


    private fun onLoadLastDataFromInternet(): Observable<ArticleView>? {
        return articleApi.getLastArticle(LastArticleRequestModel(CurrentUser.login, CurrentUser.token).toRequest())
            .flatMap {
                Observable.fromIterable(it.response!!.list)
            }
            .doOnNext {
                getIdOffset = it.id
            }
            .doOnNext {
                //TODO сохранения в базу данных
            }
            .flatMap {
                val list = mutableListOf<ArticleView>()
                list.add(ArticleView(it))
                Observable.fromIterable(list)
            }
    }


    override fun loadDataOffset(): Single<List<ArticleView>> {
        return networkManager.getNetworkStatus().flatMap {
            when (it) {
                true -> loadOffset(getIdOffset)
                false -> Observable.empty()
            }
        }.toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


    private fun loadOffset(idOffset: Int): Observable<ArticleView>? {
        return articleApi.getArticleOffset(
            OffsetArticleRequestModel(
                CurrentUser.login,
                CurrentUser.token,
                getIdOffset.toString()
            ).toRequest()
        ).flatMap {
            Observable.fromIterable(it.response!!.list)
        }.doOnNext {
            getIdOffset = it.id
        }.doOnNext {
            //TODO сохранение в бд
        }.flatMap {
            val list = mutableListOf<ArticleView>()
            list.add(ArticleView(it))
            Observable.fromIterable(list)
        }
    }


    //TODO загружаем из базы данных
    private fun onLoadDataFromDatabase(): Observable<ArticleView>? {
        return null
    }


}