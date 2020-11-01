package com.example.githubclone.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubclone.R
import com.example.githubclone.model.Repository
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {
    private var repositoryId = 0
    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
//            repositoryId = DetailFragmentArgs.fromBundle(
//                it
//            ).repoId
            repository = DetailFragmentArgs.fromBundle(
                it
            ).GithubRepository

            textViewRepoName.text = repository.repoName
            textViewRepoDescription.text = repository.repoDescription
            textViewRepoStarsCount.text = "Stars : ${repository.repoGivenStars}"
            textViewRepoForkCount.text = " Forks : ${repository.repoForks}"
        }


    }

}