package com.evgeny.goncharov.graduationproject.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.managers.fragment.ActivityFragmentManager
import com.evgeny.goncharov.graduationproject.common.utils.CurrentUser
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_CREATE
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_ENTRY
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_WALL
import com.evgeny.goncharov.graduationproject.di.component.AppComponent
import com.evgeny.goncharov.graduationproject.di.component.DaggerAppComponent
import com.evgeny.goncharov.graduationproject.mvp.contract.MainActivityContract
import com.evgeny.goncharov.graduationproject.mvp.presenter.MainPresenter
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.CreateArticleFlowFragment
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.EntryFlowFragment
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.WallFlowFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), Router, MainActivityContract.MainView {


    companion object {
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var flowFragmentManager: ActivityFragmentManager

    lateinit var presenter: MainActivityContract.MainPresenter


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
    private fun firstLaunch() {
        val sharedPreferences =
            getSharedPreferences("com.evgeny.goncharov.launch", Context.MODE_PRIVATE)
        val isFirstLaunch = sharedPreferences.getBoolean("firstRun", true)

        if (isFirstLaunch) {
            sharedPreferences.edit().putBoolean("firstRun", false).apply()
        }

        startOnScreen(START_FRAGMENT_ENTRY)
    }


    private fun initPresenter() {
        presenter = MainPresenter(this)
    }


    override fun onBackPressed() {
        flowFragmentManager.onBackPressed()
    }


    override fun startOnScreen(key: Int) {
        when (key) {
            START_FRAGMENT_ENTRY -> flowFragmentManager.setFlowFragment(EntryFlowFragment(), R.id.fill)
            START_FRAGMENT_WALL -> flowFragmentManager.setFlowFragment(WallFlowFragment(), R.id.fill)
            START_FRAGMENT_CREATE -> flowFragmentManager.setFlowFragment(CreateArticleFlowFragment(), R.id.fill)
        }
        val inputMethod = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethod.hideSoftInputFromWindow(fill.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }


    override fun exit() {
        startOnScreen(START_FRAGMENT_ENTRY)
        presenter.logout()
        CurrentUser.logout()
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
