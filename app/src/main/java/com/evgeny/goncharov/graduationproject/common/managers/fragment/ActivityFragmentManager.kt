package com.evgeny.goncharov.graduationproject.common.managers.fragment

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.BaseFlowFragment

class ActivityFragmentManager(private val mainActivity: MainActivity) {

    lateinit var flowFragmentOnScreen : BaseFlowFragment

    fun setFlowFragment(fragment: Fragment, @IdRes id: Int) {
        flowFragmentOnScreen = fragment as BaseFlowFragment
        mainActivity.supportFragmentManager.beginTransaction()
            .replace(id, fragment)
            .commit()
    }



    fun onBackPressed(){
        flowFragmentOnScreen.onBackPressed()
    }


}