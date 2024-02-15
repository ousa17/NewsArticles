package com.oussamabw.news.ui.theme.home.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.oussamabw.news.data.network.Article
import com.oussamabw.news.ui.theme.home.ArticleEvent
import com.oussamabw.news.ui.theme.home.ArticleViewModel

@Composable
fun ArticleList(viewModel: ArticleViewModel) {

    val lazyArticleItems: LazyPagingItems<Article> =
        viewModel.articles.collectAsLazyPagingItems()

    Column {

        Inputs(viewModel = viewModel)

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            items(lazyArticleItems) { item ->
                item?.let { article ->
                    if (article.isBBCNews())
                        BBCArticleItem(article) { viewModel.onEvent(ArticleEvent.OpenWebView(article.url)) }
                    else
                        ArticleItem(article) { viewModel.onEvent(ArticleEvent.OpenWebView(article.url)) }
                }
            }
        }
    }
}

private fun Article.isBBCNews(): Boolean = source.id == "bbc-news"


