package com.evgeny.goncharov.graduationproject.di.component

import android.content.Context
import com.evgeny.goncharov.graduationproject.di.module.ModuleActivityProvide
import com.evgeny.goncharov.graduationproject.di.module.ModuleManagersProvides
import com.evgeny.goncharov.graduationproject.di.module.ModuleRest
import com.evgeny.goncharov.graduationproject.mvp.presenter.AuthorizationPresenter
import com.evgeny.goncharov.graduationproject.mvp.presenter.MainPresenter
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.EntryFlowFragment
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

    //holder


    //presenter
    fun inject(authorizationPresenter : AuthorizationPresenter)

    fun inject(mainPresenter: MainPresenter)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(context: Context) : Builder

        @BindsInstance
        fun activity(router: Router) : Builder

        fun build() : AppComponent
    }


}