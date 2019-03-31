package com.evgeny.goncharov.graduationproject.model.view

import com.evgeny.goncharov.graduationproject.model.model.Article


/**
 * Created by Evgeny Goncharov on 2019-03-28.
 * jtgn@yandex.ru
 */


class ArticleView(article: Article) {

    val name: String = article.nameArticle

    val textArticle: String = article.text

    val id: Int = article.id

}