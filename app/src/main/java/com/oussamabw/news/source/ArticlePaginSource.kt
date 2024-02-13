package com.oussamabw.news.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.oussamabw.news.data.network.ApiService
import com.oussamabw.news.data.network.Article
import java.io.IOException
import javax.inject.Singleton

@Singleton
class ArticlePaginSource(
    private val service: ApiService,
    private val searchField: String,
    private val searchInField: String,
) : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val startPosition = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getArticles(
                page = startPosition,
                searchField = searchField,
                searchInField = searchInField,
                pageSize = 10
            )
            val articles = response.body()?.articles.orEmpty()
            LoadResult.Page(
                data = articles,
                prevKey = if (startPosition == STARTING_PAGE_INDEX) null else startPosition - 10,
                nextKey = if (articles.isEmpty()) null else startPosition + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}