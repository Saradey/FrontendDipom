package com.evgeny.goncharov.graduationproject.ui.fragment

import android.arch.paging.PagedList
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.MainThreadExecutor
import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import com.evgeny.goncharov.graduationproject.mvp.contract.WallUserContract
import com.evgeny.goncharov.graduationproject.mvp.presenter.WallUserPresenter
import com.evgeny.goncharov.graduationproject.ui.adapters.source.PositionalDataSourceWallUser
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.WallFlowContract
import java.util.concurrent.Executors


/**
 * Created by Evgeny Goncharov on 2019-04-01.
 * jtgn@yandex.ru
 */


class WallForUserFragment : BaseWallFragment(), WallUserContract.WallUserView {

    lateinit var presenter: WallUserContract.WallUserPresenter


    companion object {
        fun getInstance(wallFlowContract: WallFlowContract): BaseWallFragment {
            val wallAllFragment = WallForUserFragment()
            wallAllFragment.wallFlowContract = wallFlowContract
            return wallAllFragment
        }
    }


    override fun initPagerAdapter(): PagedList<ArticleView> {
        val dataSource = PositionalDataSourceWallUser(presenter)
        return PagedList.Builder(dataSource, getConfigPagerAdapter())
            .setNotifyExecutor(MainThreadExecutor())
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()
    }


    override fun getTitle(): Int {
        return R.string.title_user_article_str
    }


    override fun initPresenter() {
        presenter = WallUserPresenter(this)
    }


}