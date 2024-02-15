package com.oussamabw.news.ui.theme.home

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.oussamabw.news.data.network.Article
import com.oussamabw.news.domain.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _articleState = MutableStateFlow(ArticleState())
    val articleState: MutableStateFlow<ArticleState> = _articleState

    fun onEvent(event: ArticleEvent) {
        when (event) {
            is ArticleEvent.SearchArticles -> {
                _articleState.update {
                    it.copy(
                        searchField = event.searchField
                    )
                }
            }

            is ArticleEvent.OpenWebView -> _articleState.update {
                it.copy(
                    urlWebView = event.url
                )
            }

            ArticleEvent.CloseWebView -> articleState.update {
                it.copy(
                    urlWebView = null
                )
            }
        }
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    val articles: Flow<PagingData<Article>> = _articleState.flatMapLatest {
        getArticlesUseCase(it.searchField).flowOn(dispatcher)
    }

}