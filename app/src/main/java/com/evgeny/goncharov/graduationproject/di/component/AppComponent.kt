package com.evgeny.goncharov.graduationproject.di.component

import android.content.Context
import com.evgeny.goncharov.graduationproject.di.module.ModuleActivityProvide
import com.evgeny.goncharov.graduationproject.di.module.ModuleManagersProvides
import com.evgeny.goncharov.graduationproject.di.module.ModuleRest
import com.evgeny.goncharov.graduationproject.mvp.presenter.AuthorizationPresenter
import com.evgeny.goncharov.graduationproject.mvp.presenter.MainPresenter
import com.evgeny.goncharov.graduationproject.mvp.presenter.RegistrationPresenter
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.EntryFlowFragment
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.WallFlowFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleManagersProvides::class,
    ModuleActivityProvide::class,
    ModuleRest::class])
interface AppComponent{

    //activity
    fun inject(mainActivity: MainActivity)



    //fragment
    fun inject(entryFlowFragment: EntryFlowFragment)

    fun inject(wallFlowFragment: WallFlowFragment)

    //holder


    //presenter
    fun inject(presenter : AuthorizationPresenter)

    fun inject(presenter: MainPresenter)

    fun inject(presenter : RegistrationPresenter)


    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(context: Context) : Builder

        @BindsInstance
        fun activity(router: Router) : Builder

        fun build() : AppComponent
    }


}