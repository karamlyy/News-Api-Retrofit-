package com.example.newsappretrofit.api

import com.example.newsappretrofit.model.Results
import retrofit2.Call
import retrofit2.http.GET



interface Api {

    @GET("3c86374a-738d-4911-bf09-1dac9e9760e4")
    fun getNews(): Call<Results?>?
}