package com.oussamabw.news.data


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.oussamabw.news.core.SEARCH_IN_FIELD
import com.oussamabw.news.data.network.ApiService
import com.oussamabw.news.data.network.Article
import com.oussamabw.news.domain.ArticleRepository
import com.oussamabw.news.source.ArticlePaginSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryArticleImpl @Inject constructor(private val service: ApiService) :
    ArticleRepository {

    override fun getArticles(searchField: String): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 10),
            pagingSourceFactory = { ArticlePaginSource(service, searchField, SEARCH_IN_FIELD) }
        ).flow
    }
}