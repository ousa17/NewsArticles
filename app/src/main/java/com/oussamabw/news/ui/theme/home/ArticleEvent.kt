package com.oussamabw.news.ui.theme.home


sealed class ArticleEvent {
    data class SearchArticles(val searchField: String) : ArticleEvent()
    data class OpenWebView(val url: String) : ArticleEvent()

    data object CloseWebView : ArticleEvent()
}