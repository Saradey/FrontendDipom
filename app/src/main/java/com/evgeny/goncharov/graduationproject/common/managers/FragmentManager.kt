package com.evgeny.goncharov.graduationproject.common.managers

import android.support.annotation.IdRes
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.fragment.BaseFragment


class FragmentManager (mainActivity: MainActivity): BaseFragmentManager(mainActivity){

    //текущий базовый фрагмент
    lateinit var baseFragment: BaseFragment



    fun setBaseFragment(fragment: BaseFragment, @IdRes id : Int){
        this.baseFragment = fragment
        setFragment(fragment, id)
    }




}