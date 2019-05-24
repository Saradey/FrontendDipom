package com.evgeny.goncharov.graduationproject.ui.fragment.flow

import android.os.Bundle
import android.support.annotation.StringRes
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.managers.fragment.EntryFragmentManager
import com.evgeny.goncharov.graduationproject.common.managers.fragment.FlowFragmentManager
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_AUTHORIZATION
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_REGISTRATION
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_WALL
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import com.evgeny.goncharov.graduationproject.ui.dialog.AskExitDialog
import com.evgeny.goncharov.graduationproject.ui.fragment.AuthorizationFragment
import com.evgeny.goncharov.graduationproject.ui.fragment.RegistrationFragment
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.EntryFlowContract
import javax.inject.Inject


class EntryFlowFragment : BaseFlowFragment(), EntryFlowContract {


    lateinit var fragmentManager: EntryFragmentManager

    @Inject
    lateinit var router: Router


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.appComponent.inject(this)
        fragmentManager = EntryFragmentManager(this)
        startOnScreen(START_FRAGMENT_AUTHORIZATION)
    }


    //сетая тайтл экрана
    override fun setTitle(@StringRes title: Int) {
        requireActivity().setTitle(title)
    }

    //иницилизация фрагмента авторизации происходит первой
    private fun initAuthorization() {
        fragmentManager
            .addBaseFragment(
                AuthorizationFragment.getInstance(this), R.id.fill_enter
            )
    }


    private fun initRegistration() {
        fragmentManager
            .addBaseFragment(
                RegistrationFragment.getInstance(this), R.id.fill_enter
            )
    }


    override fun startOnScreen(key: Int) {
        when (key) {
            START_FRAGMENT_AUTHORIZATION -> initAuthorization()
            START_FRAGMENT_REGISTRATION -> initRegistration()
        }
    }


    override fun getLayoutContentView(): Int {
        return R.layout.fragment_flow
    }


    override fun popBaseFragment() {
        fragmentManager.popBaseFragment()
    }


    override fun authenticationDone() {
        router.startOnScreen(START_FRAGMENT_WALL)
    }

    //если нажали назад
    override fun onBackPressed() {
        if (!fragmentManager.onBackPressed()) {
            val dialog = AskExitDialog()
            dialog.show(requireActivity().supportFragmentManager, dialog.javaClass.name)
        }
    }


}