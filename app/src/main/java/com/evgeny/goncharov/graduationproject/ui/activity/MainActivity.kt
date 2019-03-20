package com.evgeny.goncharov.graduationproject.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.managers.FlowFragmentManager
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_AUTHORIZATION
import com.evgeny.goncharov.graduationproject.di.component.AppComponent
import com.evgeny.goncharov.graduationproject.di.component.DaggerAppComponent
import com.evgeny.goncharov.graduationproject.mvp.contract.MainActivityContract
import com.evgeny.goncharov.graduationproject.mvp.presenter.MainPresenter
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.EntryFlowFragment
import javax.inject.Inject
import android.widget.Toast



class MainActivity : AppCompatActivity(), Router, MainActivityContract.MainView {


    companion object{
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var flowFragmentManager: FlowFragmentManager

    lateinit var presenter : MainActivityContract.MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appComponent = DaggerAppComponent
                .builder()
                .application(application)
                .activity(this)
                .build()

        appComponent.inject(this)

        firstLaunch()
        initPresenter()
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



    private fun initPresenter() {
        presenter = MainPresenter(this)
    }



    override fun onBackPressed() {

    }



    override fun startOnScreen(key: Int) {
        when(key){
            START_FRAGMENT_AUTHORIZATION -> flowFragmentManager.setFragment(EntryFlowFragment(), R.id.fill)
        }
    }


    override fun onStop() {
        super.onStop()
        presenter.logout()
    }


    override fun onResume() {
        super.onResume()
        presenter.goToTheAuthentication()
    }

}
