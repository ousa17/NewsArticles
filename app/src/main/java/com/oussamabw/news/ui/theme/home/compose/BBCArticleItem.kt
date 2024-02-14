package com.oussamabw.news.ui.theme.home.compose

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.oussamabw.news.data.network.Article
import com.oussamabw.news.data.network.ArticleSource

@Composable
fun BBCArticleItem(article: Article) {

    Card(
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
                    contentScale = ContentScale.FillBounds // Adjust the scaling to fit the image style you want
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


@Preview
@Composable
fun PreviewMaterialText() {
    BBCArticleItem(
        Article(
            ArticleSource("", ""),
            author = "author",
            title = "Does rugby need goal-line technology?",
            description = "After Scotland's TMO drama, is goal-line technology the answer for 'conclusive evidence'?",
            url = "https://www.bbc.co.uk/sport/av/rugby-union/68282885",
            urlToImage = "https://ichef.bbci.co.uk/news/1024/cpsprodpb/175CC/production/_132629659_p0hbk1w6.jpg"
        )
    )
}