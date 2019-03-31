package com.evgeny.goncharov.graduationproject.ui.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.model.view.ArticleView
import kotlinx.android.synthetic.main.holder_article.view.*


/**
 * Created by Evgeny Goncharov on 2019-03-28.
 * jtgn@yandex.ru
 */
 

class ArticleHolder (val view: View) : RecyclerView.ViewHolder(view){


    fun onBindView(articleView : ArticleView?){
        articleView?.let {
            view.name_article.text = "${it.name} ${it.id}"
            view.article_text.text = it.textArticle
        }
    }

}