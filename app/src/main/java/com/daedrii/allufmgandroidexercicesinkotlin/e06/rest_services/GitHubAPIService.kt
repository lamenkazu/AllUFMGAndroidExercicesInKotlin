package com.daedrii.allufmgandroidexercicesinkotlin.e06.rest_services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubAPIService {

    @GET("users/{username}") //link chamado após o baseURL do RetrofitConfig
    fun getUser(@Path("username") username: String): Call<GitHubUser> //Define a variavel {username} com o que é passado por parâmetro no método getUser()

}