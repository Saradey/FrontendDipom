package com.evgeny.goncharov.graduationproject.ui.fragment

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.annotation.UiThread
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.evgeny.goncharov.graduationproject.mvp.contract.AuthorizationContract
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_AUTHORIZATION
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_REGISTRATION
import com.evgeny.goncharov.graduationproject.mvp.presenter.AuthorizationPresenter
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.EntryFlowContract
import kotlinx.android.synthetic.main.fragment_authorization.*

class AuthorizationFragment : BaseFragment(), AuthorizationContract.AuthorizationView {

    lateinit var entryFlowContract: EntryFlowContract

    lateinit var presenter: AuthorizationContract.AuthorizationPresenter


    companion object {
        fun getInstance(entryFlowContract: EntryFlowContract): AuthorizationFragment {
            val authorizationFragment = AuthorizationFragment()
            authorizationFragment.entryFlowContract = entryFlowContract
            return authorizationFragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        entryFlowContract.setTitle(getTitle())
        initPresenter()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUiLogic()
    }


    private fun initUiLogic() {
        enter_button.setOnClickListener {
            val login = input_login.text.toString()
            val password = input_password.text.toString()
            if(login.length > 2 && password.length > 2)
                presenter.goToTheAuthentication(login, password)
        }


        button_registration.setOnClickListener {
            entryFlowContract.startOnScreen(START_FRAGMENT_REGISTRATION)
        }

    }


    override fun initPresenter() {
        presenter = AuthorizationPresenter(this)
    }


    override fun getLayoutContentView(): Int {
        return R.layout.fragment_authorization
    }


    override fun getTitle(): Int {
        return R.string.title_auto
    }


    override fun error() {
        makeToast(R.string.auto_error_str)
    }


    override fun authenticationDone() {
        entryFlowContract.authenticationDone()
    }


    private fun makeToast(@StringRes idString : Int){
        val toastOk = Toast.makeText(requireActivity(), idString, Toast.LENGTH_LONG)
        toastOk.show()
    }


}