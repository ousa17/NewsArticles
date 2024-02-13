package com.oussamabw.news.ui.theme.home


sealed class ArticleEvent {
    data class LoadWithLatLon(val lat: String, val lon: String) : ArticleEvent()
}