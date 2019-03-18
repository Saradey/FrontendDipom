package com.evgeny.goncharov.graduationproject.common.managers

import android.support.annotation.IdRes
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.fragment.BaseFlowFragment
import javax.inject.Inject

abstract class BaseFragmentManager (val mainActivity: MainActivity){

    lateinit var baseFlowFragment : BaseFlowFragment


    fun setFragmentFlow(fragment : BaseFlowFragment, @IdRes id : Int){
        this.baseFlowFragment = fragment
        mainActivity.supportFragmentManager.beginTransaction()
                .replace(id, fragment)
                .commit()
    }

}