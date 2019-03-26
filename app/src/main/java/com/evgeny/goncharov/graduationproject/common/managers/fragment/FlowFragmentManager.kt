package com.evgeny.goncharov.graduationproject.common.managers.fragment

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.evgeny.goncharov.graduationproject.ui.fragment.BaseFragment
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.BaseFlowFragment
import java.util.*


abstract class FlowFragmentManager(baseFlowFragment: BaseFlowFragment) {

    //текущий базовый фрагмент
    lateinit var baseFragment: BaseFragment

    var stackFragment = Stack<BaseFragment>()

    var manager: FragmentManager = baseFlowFragment.childFragmentManager


    fun addBaseFragment(fragment: BaseFragment, @IdRes id: Int) {
        this.baseFragment = fragment
        stackFragment.push(fragment)
        addFragment(fragment, id)
    }


    private fun addFragment(fragment: Fragment, @IdRes id: Int) {
        manager.beginTransaction()
            .addToBackStack(fragment.javaClass.name)
            .replace(id, fragment)
            .commit()
    }


    fun popBaseFragment() {
        manager.popBackStack()
        stackFragment.pop()
        baseFragment = stackFragment.lastElement()
    }


}