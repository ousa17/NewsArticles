package com.oussamabw.news.ui.theme.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.oussamabw.news.data.network.Article

@Composable
fun BBCArticleItem(article: Article, action: () -> Unit) {

    Card(
        modifier = Modifier.clickable {
            action()
        },
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(article.urlToImage),
                    contentDescription = null, // Provide a proper content description for accessibility
                    modifier = Modifier
                        .height(180.dp) // or whatever height you want
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth // Adjust the scaling to fit the image style you want
                )
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = article.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )
                    Text(
                        text = article.description,
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}