package com.evgeny.goncharov.graduationproject.common.managers

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.BaseFlowFragment

abstract class BaseFragmentManager (private val mainActivity: MainActivity){


    fun setFragment(fragment : Fragment, @IdRes id : Int){
        mainActivity.supportFragmentManager.beginTransaction()
                .replace(id, fragment)
                .commit()
    }


}