package com.daedrii.allufmgandroidexercicesinkotlin.e06.rest_services

import com.google.gson.annotations.SerializedName

//Classe que representa um usuário do GitHub
data class GitHubUser(
    val name: String,
    val login: String,
    val company: String,
    val blog: String,
    val location: String,
    val email: String,
    val bio: String,
    @SerializedName("public_repos") val repos: Number,
    val followers: Number)