package com.evgeny.goncharov.graduationproject.ui.adapters.utils

import android.support.v7.util.DiffUtil
import com.evgeny.goncharov.graduationproject.model.view.ArticleView


/**
 * Created by Evgeny Goncharov on 2019-03-28.
 * jtgn@yandex.ru
 */


class DiffUtilCallback : DiffUtil.ItemCallback<ArticleView>(){

    override fun areItemsTheSame(p0: ArticleView, p1: ArticleView): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: ArticleView, p1: ArticleView): Boolean {
        return p0.hashCode() == p1.hashCode()
    }

}