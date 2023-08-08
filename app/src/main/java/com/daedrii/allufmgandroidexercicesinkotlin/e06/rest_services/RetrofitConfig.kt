package com.daedrii.allufmgandroidexercicesinkotlin.e06.rest_services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getGitHubService(): GitHubAPIService{
        return retrofit.create(GitHubAPIService::class.java)
    }

    companion object{ // Modo de criar métodos staticos no Kotlin - Companion Object
        private var instance: RetrofitConfig ? = null

        fun getInstance(): RetrofitConfig{
            if(instance == null){
                instance = RetrofitConfig()
            }
            return instance as RetrofitConfig
        }
    }

}