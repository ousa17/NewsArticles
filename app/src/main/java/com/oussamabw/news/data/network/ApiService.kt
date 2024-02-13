package com.oussamabw.news.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything?domains=bbc.co.uk,techcrunch.com&apiKey=1b18650f51454f80a97facb29c252ce5")
    suspend fun getArticles(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Response<ArticleResponse>
}