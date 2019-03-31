package com.evgeny.goncharov.graduationproject.ui.fragment.flow

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.managers.fragment.CreateArticleFragmentManager
import com.evgeny.goncharov.graduationproject.consts.START_CREATE_ARTICLE_FRAGMENT
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_WALL
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import com.evgeny.goncharov.graduationproject.ui.fragment.CreateArticleFragment
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.CreateArticleFlowContract
import javax.inject.Inject


/**
 * Created by Evgeny Goncharov on 2019-03-31.
 * jtgn@yandex.ru
 */


class CreateArticleFlowFragment : BaseFlowFragment(), CreateArticleFlowContract {


    @Inject
    lateinit var router: Router

    lateinit var createArticleManager: CreateArticleFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.appComponent.inject(this)
        createArticleManager = CreateArticleFragmentManager(this)
        startOnScreen(START_CREATE_ARTICLE_FRAGMENT)
        setupActionBar()
    }


    private fun setupActionBar() {
        setHasOptionsMenu(true)
        onOrOffActionBar(true)
    }


    private fun onOrOffActionBar(onOrOff: Boolean) {
        val actionBar = (requireActivity() as MainActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(onOrOff)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onOrOffActionBar(false)
                router.startOnScreen(START_FRAGMENT_WALL)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun goToTheWall() {
        onOrOffActionBar(false)
        router.startOnScreen(START_FRAGMENT_WALL)
    }


    override fun getLayoutContentView(): Int {
        return R.layout.fragment_flow
    }


    override fun onBackPressed() {
        onOrOffActionBar(false)
        router.startOnScreen(START_FRAGMENT_WALL)
    }


    override fun setTitle(title: Int) {
        requireActivity().setTitle(title)
    }


    override fun startOnScreen(key: Int) {
        when (key) {
            START_CREATE_ARTICLE_FRAGMENT -> initCreateArticle()
        }
    }


    private fun initCreateArticle() {
        createArticleManager.addBaseFragment(
            CreateArticleFragment.getInstance(this),
            R.id.fill_enter
        )
    }


}