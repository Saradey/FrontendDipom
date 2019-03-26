package com.evgeny.goncharov.graduationproject.common.managers.fragment

import com.evgeny.goncharov.graduationproject.ui.fragment.BaseFragment
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.BaseFlowFragment

class EntryFragmentManager(baseFlowFragment: BaseFlowFragment) : FlowFragmentManager(baseFlowFragment) {


    private fun getClazzFragment(): Class<BaseFragment> {
        return baseFragment.javaClass
    }


    fun onBackPressed(): Boolean {
        if (getClazzFragment().name.matches(Regex(".*RegistrationFragment"))) {
            popBaseFragment()
            return true
        }
        return false
    }


}