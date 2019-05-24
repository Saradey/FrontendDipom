package com.evgeny.goncharov.graduationproject.mvp.presenter

import android.annotation.SuppressLint
import com.evgeny.goncharov.graduationproject.common.managers.ErrorManager
import com.evgeny.goncharov.graduationproject.common.managers.NetworkManager
import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.mvp.contract.AuthorizationContract
import com.evgeny.goncharov.graduationproject.rest.api.UserApi
import com.evgeny.goncharov.graduationproject.rest.model.request.UserRequestToken
import com.evgeny.goncharov.graduationproject.rest.model.request.post.RequestAuthorizationBody
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import com.evgeny.goncharov.graduationproject.rest.model.response.Response
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthorizationPresenter(val view: AuthorizationContract.AuthorizationView) :
    AuthorizationContract.AuthorizationPresenter {

    @Inject
    lateinit var networkManager: NetworkManager

    @Inject
    lateinit var userApi: UserApi

    @Inject
    lateinit var currentUser: CurrentUser


    init {
        MainActivity.appComponent.inject(this)
    }


    @SuppressLint("CheckResult")
    override fun goToTheAuthentication(login: String, password: String) {
        networkManager.getNetworkStatus()
            .flatMap {
                when (it) {
                    true -> authenticationRequest(login, password)
                    false -> throw Throwable(ErrorManager.CONNECT_FIELD)
                }
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.authenticationDone()
            }, {
                it.printStackTrace()
                view.error()
            })
    }



    private fun authenticationRequest(login: String, password: String): Observable<Full<Response>> {
        currentUser.parseStringToBase64(login, password)
        return userApi.authorization(
            currentUser.pasNameBase64,
            RequestAuthorizationBody()
        )
    }

}