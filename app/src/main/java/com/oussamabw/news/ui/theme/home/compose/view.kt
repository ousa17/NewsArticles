package com.oussamabw.news.ui.theme.home.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import com.oussamabw.news.ui.theme.home.ArticleViewModel

@Composable
fun ArticleList(viewModel: ArticleViewModel) {

    val lazyArticleItems: LazyPagingItems<Article> =
        viewModel.articles.collectAsLazyPagingItems()


    Column(content = function(viewModel, lazyArticleItems))
}

@Composable
private fun function(
    viewModel: ArticleViewModel,
    lazyArticleItems: LazyPagingItems<Article>
): @Composable() (ColumnScope.() -> Unit) =
    {

        Inputs(viewModel = viewModel)

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            items(lazyArticleItems) { item ->
                item?.let { article ->
                    if (article.isBBCNews())
                        BBCArticleItem(article)
                    else
                        ArticleItem(article)

                }
            }
        }
    }

private fun Article.isBBCNews(): Boolean = source.id == "bbc-news"


