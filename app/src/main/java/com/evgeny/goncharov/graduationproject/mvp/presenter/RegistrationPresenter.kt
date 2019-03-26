package com.evgeny.goncharov.graduationproject.mvp.presenter

import android.annotation.SuppressLint
import com.evgeny.goncharov.graduationproject.common.managers.ErrorManager
import com.evgeny.goncharov.graduationproject.common.managers.NetworkManager
import com.evgeny.goncharov.graduationproject.mvp.contract.RegistrationContract
import com.evgeny.goncharov.graduationproject.rest.api.UserApi
import com.evgeny.goncharov.graduationproject.rest.model.request.RegistrationRequest
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import com.evgeny.goncharov.graduationproject.rest.model.response.Response
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RegistrationPresenter(val view: RegistrationContract.RegistrationView) :
    RegistrationContract.RegistrationPresenter {

    @Inject
    lateinit var userApi: UserApi

    @Inject
    lateinit var networkManager: NetworkManager


    init {
        MainActivity.appComponent.inject(this)
    }


    @SuppressLint("CheckResult")
    override fun requestRegistration(log: String, pas: String, email: String) {
        networkManager.getNetworkStatus()
            .flatMap {
                when (it) {
                    true -> request(log, pas, email)
                    false -> throw Throwable(ErrorManager.CONNECT_FIELD)
                }
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.registrationOk()
            }, {
                view.errorRegistration()
                it.printStackTrace()
            })
    }


    private fun request(log: String, pas: String, email: String): Observable<Full<Response>> {
        return userApi.registration(RegistrationRequest(log, pas, email).toRequest())
    }


}