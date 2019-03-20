package com.evgeny.goncharov.graduationproject.ui.fragment.flow

import android.os.Bundle
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.managers.FragmentManager
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import com.evgeny.goncharov.graduationproject.ui.fragment.AuthorizationFragment
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.EntryFlowContract
import javax.inject.Inject


class EntryFlowFragment : BaseFlowFragment(), EntryFlowContract {


    @Inject
    lateinit var fragmentManager: FragmentManager

    @Inject
    lateinit var router: Router


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivity.appComponent.inject(this)

        initAuthorization()
    }

    //сетая тайтл экрана
    override fun setTitle(title: Int) {
        requireActivity().setTitle(title)
    }

    //иницилизация фрагмента авторизации происходит первой
    private fun initAuthorization() {
        fragmentManager
                .setBaseFragment(
                        AuthorizationFragment.getInstance(this), R.id.fill_enter)
    }


    override fun getLayoutContentView(): Int {
        return R.layout.fragment_flow_enter
    }


    //если нажали назад
    override fun onBackPressed() {

    }


}