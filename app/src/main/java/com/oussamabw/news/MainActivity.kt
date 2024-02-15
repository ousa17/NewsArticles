package com.oussamabw.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.oussamabw.news.ui.theme.NewsTheme
import com.oussamabw.news.ui.theme.home.ArticleEvent
import com.oussamabw.news.ui.theme.home.ArticleViewModel
import com.oussamabw.news.ui.theme.home.compose.ArticleList
import com.oussamabw.news.ui.theme.home.compose.WebViewScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: ArticleViewModel = hiltViewModel()
                    val state = viewModel.articleState.collectAsState()
                    state.value.urlWebView?.let {
                        WebViewScreen(url = it){ viewModel.onEvent(ArticleEvent.CloseWebView) }
                    } ?: ArticleList(viewModel)
                }
            }
        }
    }
}
