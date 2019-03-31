package com.evgeny.goncharov.graduationproject.ui.adapters

import android.arch.paging.PagedListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import com.evgeny.goncharov.graduationproject.ui.adapters.utils.DiffUtilCallback
import com.evgeny.goncharov.graduationproject.ui.holder.ArticleHolder


/**
 * Created by Evgeny Goncharov on 2019-03-28.
 * jtgn@yandex.ru
 */


class WallAdapter(diffUtilCallback: DiffUtilCallback) : PagedListAdapter<ArticleView, ArticleHolder>(diffUtilCallback){


    override fun onCreateViewHolder(parent: ViewGroup, idRes: Int): ArticleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_article, parent, false)
        return ArticleHolder(view)
    }



    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.onBindView(getItem(position))
    }


}