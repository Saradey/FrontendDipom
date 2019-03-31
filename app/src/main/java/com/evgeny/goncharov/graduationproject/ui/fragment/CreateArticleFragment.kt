package com.evgeny.goncharov.graduationproject.ui.fragment

import android.os.Bundle
import android.support.annotation.StringRes
import android.view.View
import android.widget.Toast
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.mvp.contract.CreateArticleContract
import com.evgeny.goncharov.graduationproject.mvp.presenter.CreateArticlePresenter
import com.evgeny.goncharov.graduationproject.ui.fragment.flow.contract.CreateArticleFlowContract
import kotlinx.android.synthetic.main.fragment_create_article.*


/**
 * Created by Evgeny Goncharov on 2019-03-31.
 * jtgn@yandex.ru
 */


class CreateArticleFragment : BaseFragment(), CreateArticleContract.CreateArticleView {

    lateinit var createArticleFlow: CreateArticleFlowContract

    lateinit var presenter: CreateArticleContract.CreateArticlePresenter


    companion object {
        fun getInstance(createArticleFlow: CreateArticleFlowContract): CreateArticleFragment {
            val instance = CreateArticleFragment()
            instance.createArticleFlow = createArticleFlow
            return instance
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUILogic()
        initPresenter()
    }


    private fun initUILogic() {
        publish_article_button.setOnClickListener {
            presenter.loadArticleToServer(input_article.text.toString(), input_name_article.text.toString())
            Thread.sleep(500)
            createArticleFlow.goToTheWall()
        }
    }


    override fun getLayoutContentView(): Int {
        return R.layout.fragment_create_article
    }


    override fun getTitle(): Int {
        return R.string.title_create_article_str
    }


    override fun initPresenter() {
        presenter = CreateArticlePresenter(this)
    }


    override fun success() {
        makeToast(R.string.success_str)
    }


    override fun filed() {
        makeToast(R.string.filed_str)
    }


    private fun makeToast(@StringRes idString: Int) {
        val toastOk = Toast.makeText(requireActivity(), idString, Toast.LENGTH_LONG)
        toastOk.show()
    }

}