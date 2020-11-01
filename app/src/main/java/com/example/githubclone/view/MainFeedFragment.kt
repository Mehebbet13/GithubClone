package com.example.githubclone.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubclone.R
import com.example.githubclone.adapter.RepositoryAdapter
import com.example.githubclone.model.Repository
import com.example.githubclone.service.GithubAPI
import com.example.githubclone.service.GithubAPIService
import com.example.githubclone.viewModel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_main_feed.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainFeedFragment : Fragment() {
     var repositoryAdapter =  RepositoryAdapter(arrayListOf())
    private lateinit var viewModel: FeedViewModel

    var githubAPIService = GithubAPIService()
    var repoList: List<Repository> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_feed, container, false)
    }
    fun observeLiveData() {
        viewModel.repositories.observe(viewLifecycleOwner,
            Observer { repositories ->
                repositories?.let {
                    repositoryAdapter = RepositoryAdapter(repositories)
                    rv.layoutManager = LinearLayoutManager(context)
                    rv.adapter = repositoryAdapter
                }
            })
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.getAllData()
        observeLiveData()


    }

}