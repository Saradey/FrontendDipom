package com.evgeny.goncharov.graduationproject.mvp.presenter

import android.annotation.SuppressLint
import com.evgeny.goncharov.graduationproject.common.managers.ErrorManager
import com.evgeny.goncharov.graduationproject.common.managers.NetworkManager
import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.model.model.Token
import com.evgeny.goncharov.graduationproject.mvp.contract.AuthorizationContract
import com.evgeny.goncharov.graduationproject.rest.api.UserApi
import com.evgeny.goncharov.graduationproject.rest.model.request.UserRequestToken
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class AuthorizationPresenter(val view: AuthorizationContract.AuthorizationView) : AuthorizationContract.AuthorizationPresenter {

    @Inject
    lateinit var networkManager: NetworkManager

    @Inject
    lateinit var userApi: UserApi


    init {
        MainActivity.appComponent.inject(this)
    }


    @SuppressLint("CheckResult")
    override fun goToTheAuthentication(login: String, password: String) {
        CurrentUser.login = login
        networkManager.getNetworkStatus()
                .flatMap {
                    when (it) {
                        true -> authenticationRequest(login, password)
                        false -> throw Throwable(ErrorManager.NO_INTERNET)
                    }
                }.subscribeOn(Schedulers.io())
                .subscribe({
                    CurrentUser.token = it.response!!.token
                    CurrentUser.login = login
                    CurrentUser.password = password
                }, {
                    it.printStackTrace()
                })
    }




    private fun authenticationRequest(login: String, password: String): Observable<Full<Token>> {
        return userApi.getToken(UserRequestToken(login, password).toRequest())
    }

}