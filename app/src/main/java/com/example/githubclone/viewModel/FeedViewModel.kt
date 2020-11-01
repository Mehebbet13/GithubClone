package com.example.githubclone.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubclone.model.Repository
import com.example.githubclone.service.GithubAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedViewModel : ViewModel() {
    val repositories = MutableLiveData<List<Repository>>()
    var githubAPIService = GithubAPIService()


    fun getAllData() {
        Log.d("repositories------", repositories.value.toString())
        githubAPIService.api.getRepositories().enqueue(object : Callback<List<Repository>> {
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                repositories.value = (response.body()!!)
                Log.d("mhbb", "showData list${repositories.value}")
                Log.d("mhbb", "showData ${response.body()!!}")

            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                Log.d("mhbb", "onFailure")
                Log.d("mhbb", "onFailure list${repositories}")

            }
        })
    }
}