package com.oussamabw.news.domain


import androidx.paging.PagingData
import com.oussamabw.news.data.network.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<PagingData<Article>>
}