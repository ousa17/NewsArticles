package com.oussamabw.news.ui.theme.home

import com.oussamabw.news.domain.GetArticlesUseCase
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

@OptIn(ExperimentalCoroutinesApi::class)
class ArticleViewModelTest {

    private val dispatcher = Dispatchers.Unconfined

    private val getArticlesUseCase: GetArticlesUseCase = mockk<GetArticlesUseCase>()

    private val viewModel: ArticleViewModel = ArticleViewModel(getArticlesUseCase, dispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getArticleState() = runTest {
        val searchQuery = "test"

        viewModel.onEvent(ArticleEvent.SearchArticles(searchField = searchQuery))

        assertEquals(viewModel.articleState.value.searchField, searchQuery)
    }

    @Test

    fun onOpenWebView() = runTest {
        val url = "http://test.com"

        viewModel.onEvent(ArticleEvent.OpenWebView(url))

        assertEquals(viewModel.articleState.value.urlWebView, url)
    }

    @Test
    fun onCloseWebView() = runTest {
        viewModel.onEvent(ArticleEvent.OpenWebView("http://test.com"))

        viewModel.onEvent(ArticleEvent.CloseWebView)

        assertNull(viewModel.articleState.value.urlWebView)
    }

    @Test
    fun getArticles() {
        //TODO
    }
}