package com.oussamabw.news.ui.theme.home


sealed class ArticleEvent {
    data class SearchArticles(val searchField:String) : ArticleEvent()
}