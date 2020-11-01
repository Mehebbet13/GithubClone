package com.example.githubclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclone.R
import com.example.githubclone.model.Repository
import com.example.githubclone.view.MainFeedFragmentDirections
import kotlinx.android.synthetic.main.card_view.view.*

class RepositoryAdapter(private val repositoryList: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    class RepositoryViewHolder(var view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = repositoryList[position]
        holder.view.name.text = repository.repoName
        holder.view.description.text = repository.repoDescription
        holder.view.cardView.setOnClickListener {
            val action = MainFeedFragmentDirections.actionMainFeedFragmentToDetailFragment(repository.repoId!!.toInt(),repository)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }
}