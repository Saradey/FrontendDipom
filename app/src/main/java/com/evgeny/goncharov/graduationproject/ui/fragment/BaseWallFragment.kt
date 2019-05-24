package com.evgeny.goncharov.graduationproject.ui.fragment

import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import com.evgeny.goncharov.graduationproject.ui.adapters.WallAdapter
import com.evgeny.goncharov.graduationproject.ui.adapters.utils.DiffUtilCallback
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.WallFlowContract
import kotlinx.android.synthetic.main.fragment_wall_all.*
import javax.inject.Inject

abstract class BaseWallFragment : BaseFragment() {

    lateinit var wallFlowContract: WallFlowContract

    lateinit var adapter: WallAdapter


    @Inject
    lateinit var router: Router


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


    abstract fun initPagerAdapter() : PagedList<ArticleView>



    fun initRecycle() {
        adapter = WallAdapter(DiffUtilCallback())
        adapter.submitList(initPagerAdapter())

        content_wall_recycle_view.layoutManager = LinearLayoutManager(requireActivity())
        content_wall_recycle_view.adapter = adapter
    }


    override fun getLayoutContentView(): Int {
        return R.layout.fragment_wall_all
    }


    fun getConfigPagerAdapter() : PagedList.Config{
        return PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(false)
            .build()
    }

}