package com.evgeny.goncharov.graduationproject.ui.fragment

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_AUTHORIZATION
import com.evgeny.goncharov.graduationproject.mvp.contract.RegistrationContract
import com.evgeny.goncharov.graduationproject.mvp.presenter.RegistrationPresenter
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.EntryFlowContract
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : BaseFragment(), RegistrationContract.RegistrationView {

    lateinit var presenter: RegistrationContract.RegistrationPresenter

    lateinit var entryFlowContract: EntryFlowContract


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        entryFlowContract.setTitle(getTitle())
        initUiLogic()
    }


    companion object {
        fun getInstance(flowFragment: EntryFlowContract): RegistrationFragment {
            val fragment = RegistrationFragment()
            fragment.entryFlowContract = flowFragment
            return fragment
        }
    }


    override fun getLayoutContentView(): Int {
        return R.layout.fragment_registration
    }


    override fun getTitle(): Int {
        return R.string.fragment_reg_str
    }


    private fun initUiLogic() {
        reg_button.setOnClickListener {
            val pas = input_password_reg.text.toString()
            val log = input_login_reg.text.toString()
            val email = input_email.text.toString()
            if (passwordAndPassword() &&
                regexCheckEmail(email) &&
                pas.length > 2 &&
                log.length > 2)
                presenter.requestRegistration(log, pas, email)
        }
    }


    private fun regexCheckEmail(email: String): Boolean {
        return email.matches(Regex("\\w+@\\w+[.]\\w+"))
    }

    private fun passwordAndPassword(): Boolean {
        return input_password_reg.text.toString() == input_password_reg_again.text.toString()
    }


    override fun registrationOk() {
        makeToast(R.string.reg_ok_str)
        entryFlowContract.popBaseFragment()
    }


    override fun errorRegistration() {
        makeToast(R.string.reg_error_str)
        entryFlowContract.popBaseFragment()
    }


    private fun makeToast(@StringRes idString : Int){
        val toastOk = Toast.makeText(requireActivity(), idString, Toast.LENGTH_LONG)
        toastOk.show()
    }


    override fun initPresenter() {
        presenter = RegistrationPresenter(this)
    }


}