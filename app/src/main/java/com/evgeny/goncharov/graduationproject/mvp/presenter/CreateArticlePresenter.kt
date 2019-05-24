package com.evgeny.goncharov.graduationproject.mvp.presenter

import android.annotation.SuppressLint
import com.evgeny.goncharov.graduationproject.common.managers.ErrorManager
import com.evgeny.goncharov.graduationproject.common.managers.NetworkManager
import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.mvp.contract.CreateArticleContract
import com.evgeny.goncharov.graduationproject.rest.api.ArticleApi
import com.evgeny.goncharov.graduationproject.rest.model.request.CreateArticleRequestModel
import com.evgeny.goncharov.graduationproject.rest.model.request.post.RequestCreateArticle
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import com.evgeny.goncharov.graduationproject.rest.model.response.Response
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Evgeny Goncharov on 2019-03-31.
 * jtgn@yandex.ru
 */

@SuppressLint("CheckResult")
class CreateArticlePresenter(val view: CreateArticleContract.CreateArticleView) :
    CreateArticleContract.CreateArticlePresenter {

    @Inject
    lateinit var networkManager: NetworkManager

    @Inject
    lateinit var articleApi: ArticleApi

    @Inject
    lateinit var currentUser: CurrentUser

    init {
        MainActivity.appComponent.inject(this)
    }


    override fun loadArticleToServer(text: String, name: String) {

        networkManager.getNetworkStatus().flatMap {
            when (it) {
                true -> request(text, name)
                false -> throw Throwable(ErrorManager.CONNECT_FIELD)
            }
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.success()
            }, {
                view.filed()
                it.printStackTrace()
            })
    }


    private fun request(text: String, name: String): Observable<Full<Response>> {
        return articleApi.createArticle(
            currentUser.pasNameBase64,
            RequestCreateArticle(name, CurrentUser.username, text)
        )
    }


}