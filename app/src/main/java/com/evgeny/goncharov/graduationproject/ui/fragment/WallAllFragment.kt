package com.evgeny.goncharov.graduationproject.ui.fragment

import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.MainThreadExecutor
import com.evgeny.goncharov.graduationproject.mvp.contract.WallAllContract
import com.evgeny.goncharov.graduationproject.mvp.presenter.WallAllPresenter
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import com.evgeny.goncharov.graduationproject.ui.adapters.WallAdapter
import com.evgeny.goncharov.graduationproject.ui.adapters.source.PositionalDataSourceArticle
import com.evgeny.goncharov.graduationproject.ui.adapters.utils.DiffUtilCallback
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.WallFlowContract
import kotlinx.android.synthetic.main.fragment_wall_all.*
import java.util.concurrent.Executors
import javax.inject.Inject

class WallAllFragment : BaseFragment(), WallAllContract.WallAllView {

    lateinit var wallFlowContract: WallFlowContract

    lateinit var presenter: WallAllContract.WallAllPresenter

    private lateinit var adapter: WallAdapter

    @Inject
    lateinit var router: Router


    companion object {
        fun getInstance(wallFlowContract: WallFlowContract): WallAllFragment {
            val wallAllFragment = WallAllFragment()
            wallAllFragment.wallFlowContract = wallFlowContract
            return wallAllFragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wallFlowContract.setTitle(getTitle())
        initUILogic()
    }


    private fun initUILogic() {
        initRecycle()
    }



    private fun initRecycle() {
        adapter = WallAdapter(DiffUtilCallback())

        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(false)
            .build()

        val dataSource = PositionalDataSourceArticle(presenter)

        val pagedList = PagedList.Builder(dataSource, config)
            .setNotifyExecutor(MainThreadExecutor())
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()

        adapter.submitList(pagedList)

        content_wall_recycle_view.layoutManager = LinearLayoutManager(requireActivity())
        content_wall_recycle_view.adapter = adapter
    }


    override fun getLayoutContentView(): Int {
        return R.layout.fragment_wall_all
    }


    override fun getTitle(): Int {
        return R.string.title_wall_str
    }


    override fun initPresenter() {
        presenter = WallAllPresenter(this)
    }


}