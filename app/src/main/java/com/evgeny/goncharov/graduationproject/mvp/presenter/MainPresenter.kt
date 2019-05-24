package com.evgeny.goncharov.graduationproject.mvp.presenter

import android.annotation.SuppressLint
import com.evgeny.goncharov.graduationproject.common.managers.ErrorManager
import com.evgeny.goncharov.graduationproject.common.managers.NetworkManager
import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.mvp.contract.MainActivityContract
import com.evgeny.goncharov.graduationproject.rest.api.UserApi
import com.evgeny.goncharov.graduationproject.rest.model.request.LogoutUserRequest
import com.evgeny.goncharov.graduationproject.rest.model.request.UserRequestToken
import com.evgeny.goncharov.graduationproject.rest.model.response.Full
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter(val view: MainActivityContract.MainView) : MainActivityContract.MainPresenter {
    @Inject
    lateinit var userApi: UserApi

    @Inject
    lateinit var networkManager: NetworkManager


    init {
        MainActivity.appComponent.inject(this)
    }
}