package com.evgeny.goncharov.graduationproject.di.module

import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import dagger.Module
import dagger.Provides


@Module
class ModuleActivityProvide{

    @Provides
    fun provideMainActivity(router: Router)
            : MainActivity = router as MainActivity

}