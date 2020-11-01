package com.example.githubclone.service

import android.util.Log
import com.example.githubclone.model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubAPIService {

    val BASE_URL = "https://api.github.com/"
    var list= ArrayList<Repository>()

    var api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GithubAPI::class.java)





}