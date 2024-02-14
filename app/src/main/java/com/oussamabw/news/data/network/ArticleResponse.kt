package com.oussamabw.news.data.network

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article(
    val source: ArticleSource,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String
)

data class ArticleSource(
    val id: String,
    val name: String
)