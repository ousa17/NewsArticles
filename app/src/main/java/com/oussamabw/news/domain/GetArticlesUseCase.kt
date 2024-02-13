package com.oussamabw.news.domain

import androidx.paging.PagingData
import com.oussamabw.news.data.network.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetArticlesUseCase @Inject constructor(private val repository: ArticleRepository) {

    operator fun invoke(searchField: String): Flow<PagingData<Article>> {
        return repository.getArticles(searchField)
    }
}