package com.evgeny.goncharov.graduationproject.di.module

import android.content.Context
import com.evgeny.goncharov.graduationproject.common.managers.fragment.ActivityFragmentManager
import com.evgeny.goncharov.graduationproject.common.managers.NetworkManager
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ModuleManagersProvides {


    @Provides
    fun provideActivityFragmentManager(mainActivity: MainActivity)
            : ActivityFragmentManager =
        ActivityFragmentManager(mainActivity)


    @Provides
    @Singleton
    fun provideNetworkManager(context: Context): NetworkManager
            = NetworkManager(context)

}