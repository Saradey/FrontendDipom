package com.evgeny.goncharov.graduationproject.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.managers.FlowFragmentManager
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_AUTHORIZATION
import com.evgeny.goncharov.graduationproject.di.component.AppComponent
import com.evgeny.goncharov.graduationproject.di.component.DaggerAppComponent
import com.evgeny.goncharov.graduationproject.ui.fragment.EntryFlowFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Router {


    companion object{
        lateinit var appComponent: AppComponent
    }


    @Inject
    lateinit var flowFragmentManager: FlowFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appComponent = DaggerAppComponent
                .builder()
                .application(application)
                .activity(this)
                .build()


        appComponent.inject(this)

        setTitle("")

        firstLaunch()
    }


    //преверка на первый запуск
    private fun firstLaunch(){
        val sharedPreferences =
                getSharedPreferences("com.evgeny.goncharov.launch", Context.MODE_PRIVATE)
        val isFirstLaunch = sharedPreferences.getBoolean("firstRun", true)

        if(isFirstLaunch) {
            sharedPreferences.edit().putBoolean("firstRun", false).apply()
        }

        startOnScreen(START_FRAGMENT_AUTHORIZATION)
    }


    override fun onBackPressed() {

    }



    override fun startOnScreen(key: Int) {
        when(key){
            START_FRAGMENT_AUTHORIZATION -> flowFragmentManager.setFragmentFlow(EntryFlowFragment(), R.id.fill)
        }
    }


}
