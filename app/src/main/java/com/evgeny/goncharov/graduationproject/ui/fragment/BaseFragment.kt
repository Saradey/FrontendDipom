package com.evgeny.goncharov.graduationproject.ui.fragment

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.BaseFlowContract

open abstract class BaseFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutContentView(), container, false)
    }

    @LayoutRes
    abstract fun getLayoutContentView(): Int

    @StringRes
    abstract fun getTitle() : Int


    abstract fun initPresenter()

}