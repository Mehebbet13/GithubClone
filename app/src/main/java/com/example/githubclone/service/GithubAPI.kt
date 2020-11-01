package com.example.githubclone.service

import com.example.githubclone.model.Repository
import retrofit2.Call
import retrofit2.http.GET

interface GithubAPI {

    @GET("users/google/repos")
    fun getRepositories():Call<List<Repository>>
}