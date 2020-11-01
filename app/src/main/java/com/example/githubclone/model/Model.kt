package com.example.githubclone.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Repository(
    @SerializedName("name")
    val repoName: String?,
    @SerializedName("id")
    val repoId: String?,
    @SerializedName("description")
    val repoDescription: String?,
    @SerializedName("stargazers_count")
    val repoGivenStars: Int?,
    @SerializedName("forks")
    val repoForks: Int?,
):Serializable