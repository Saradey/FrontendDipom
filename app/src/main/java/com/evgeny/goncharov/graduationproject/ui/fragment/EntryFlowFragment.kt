package com.evgeny.goncharov.graduationproject.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.view.menu.MenuBuilder
import android.view.View
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.managers.FragmentManager
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import javax.inject.Inject


class EntryFlowFragment : BaseFlowFragment(){


    @Inject
    lateinit var fragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivity.appComponent.inject(this)
    }



    override fun getLayoutContentView(): Int {
        return R.layout.fragment_flow_authorization
    }


    override fun getTitle(): Int? {
        return null
    }



}