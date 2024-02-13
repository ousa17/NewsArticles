package com.oussamabw.news.ui.theme.home.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.oussamabw.news.ui.theme.home.ArticleEvent
import com.oussamabw.news.ui.theme.home.ArticleViewModel

@Composable
fun Inputs(viewModel: ArticleViewModel) {


    val state by viewModel.articleState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(
            value = state.searchField,
            onValueChange = { viewModel.onEvent(ArticleEvent.SearchArticles(it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}