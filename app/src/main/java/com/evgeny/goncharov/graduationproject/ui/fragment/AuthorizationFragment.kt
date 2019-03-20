package com.evgeny.goncharov.graduationproject.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.evgeny.goncharov.graduationproject.mvp.contract.AuthorizationContract
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.mvp.presenter.AuthorizationPresenter
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.EntryFlowContract
import kotlinx.android.synthetic.main.fragment_authorization.*

class AuthorizationFragment : BaseFragment(), AuthorizationContract.AuthorizationView {

    lateinit var entryFlowContract: EntryFlowContract

    lateinit var presenter: AuthorizationContract.AuthorizationPresenter

    private var textWatcherInputLogin : TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s!!.length < 3) {
                layout_input_login.error = getString(R.string.error_input_show_str)
            } else layout_input_login.error = ""
        }
    }



    private var textWatcherInputPassword : TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s!!.length < 3) {
                layout_input_password.error = getString(R.string.error_input_show_str)
            } else layout_input_password.error = ""
        }
    }


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

        }


        input_login.addTextChangedListener(textWatcherInputLogin)
        input_password.addTextChangedListener(textWatcherInputPassword)
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


}