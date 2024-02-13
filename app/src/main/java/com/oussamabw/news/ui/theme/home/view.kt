package com.oussamabw.news.ui.theme.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.oussamabw.news.data.network.Article

@Composable
fun ArticleList(viewModel: ArticleViewModel) {

    val lazyArticleItems: LazyPagingItems<Article> =
        viewModel.articles.collectAsLazyPagingItems()


    Column {

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            items(lazyArticleItems) { item ->
                item?.let { article ->
                    ArticleItem(article)
                }
            }
        }

    }
}


@Composable
fun ArticleItem(article: Article) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
            }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Author: ${article.author}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "titre: ${article.title}",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Description: (${article.description}",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "url: (${article.url}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}