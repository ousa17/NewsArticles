package com.oussamabw.news.ui.theme.home.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oussamabw.news.data.network.Article

@Composable
fun ArticleItem(article: Article) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
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