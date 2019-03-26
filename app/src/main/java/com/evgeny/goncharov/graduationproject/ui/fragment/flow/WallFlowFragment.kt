package com.evgeny.goncharov.graduationproject.ui.fragment.flow

import android.os.Bundle
import android.view.*
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.common.managers.fragment.FlowFragmentManager
import com.evgeny.goncharov.graduationproject.common.managers.fragment.WallFragmentManager
import com.evgeny.goncharov.graduationproject.consts.START_WALL_ALL_FRAGMENT
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.WallFlowContract
import javax.inject.Inject

class WallFlowFragment : BaseFlowFragment(), WallFlowContract {

    @Inject
    lateinit var router : Router

    lateinit var wallFragmentManager: WallFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.appComponent.inject(this)
        wallFragmentManager = WallFragmentManager(this)
        startOnScreen(START_WALL_ALL_FRAGMENT)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.wall_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        when(id){
            R.id.add_article_button -> {

                return true
            }
            R.id.show_article_user -> {

                return true
            }
            R.id.show_article_class -> {

                return true
            }
            R.id.exit ->{
                router.exit()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    override fun setTitle(title: Int) {
        requireActivity().setTitle(title)
    }


    override fun startOnScreen(key: Int) {

        when(key){
            START_WALL_ALL_FRAGMENT -> initWallALlFragment()
        }

    }



    private fun initWallALlFragment() {

    }


    override fun getLayoutContentView(): Int {
        return R.layout.fragment_flow
    }



    override fun onBackPressed() {

    }


}