package com.example.sharedviewmodelapp.retrofit

import com.example.sharedviewmodelapp.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("everything?q=tesla&from=2024-05-14&sortBy=publishedAt&apiKey=4cbcd726e8af452d9ede852af03cbf6a")
    suspend fun getArticles() : Response<NewsResponse>
}