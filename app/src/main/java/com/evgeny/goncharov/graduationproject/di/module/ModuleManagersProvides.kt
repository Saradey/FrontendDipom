package com.evgeny.goncharov.graduationproject.di.module

import android.content.Context
import com.evgeny.goncharov.graduationproject.common.managers.fragment.ActivityFragmentManager
import com.evgeny.goncharov.graduationproject.common.managers.NetworkManager
import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.security.DefaultTrustManager
import com.evgeny.goncharov.graduationproject.security.base.Decoder64
import com.evgeny.goncharov.graduationproject.security.base.Encoder64
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ModuleManagersProvides {


    @Provides
    fun provideActivityFragmentManager(mainActivity: MainActivity): ActivityFragmentManager =
        ActivityFragmentManager(mainActivity)


    @Provides
    @Singleton
    fun provideNetworkManager(context: Context): NetworkManager =
        NetworkManager(context)


    @Provides
    @Singleton
    fun provideDefaultTrustManager(): DefaultTrustManager =
        DefaultTrustManager()


    @Provides
    @Singleton
    fun provideCurrentUser(): CurrentUser =
        CurrentUser()


    @Provides
    @Singleton
    fun provideDecoder(): Decoder64 =
        Decoder64()


    @Provides
    @Singleton
    fun provideEncoder(): Encoder64 =
        Encoder64()

}