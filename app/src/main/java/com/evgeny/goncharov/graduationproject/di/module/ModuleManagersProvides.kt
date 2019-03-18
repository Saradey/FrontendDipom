package com.evgeny.goncharov.graduationproject.di.module

import com.evgeny.goncharov.graduationproject.common.managers.FlowFragmentManager
import com.evgeny.goncharov.graduationproject.common.managers.FragmentManager
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ModuleManagersProvides {




    @Provides
    @Singleton
    fun provideFlowFragmentManager(mainActivity: MainActivity)
            : FlowFragmentManager = FlowFragmentManager(mainActivity)

    @Provides
    fun provideFragmentManager(mainActivity: MainActivity)
            : FragmentManager = FragmentManager(mainActivity)

}