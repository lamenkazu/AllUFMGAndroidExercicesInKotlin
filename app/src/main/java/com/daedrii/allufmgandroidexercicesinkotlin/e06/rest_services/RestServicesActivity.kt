package com.daedrii.allufmgandroidexercicesinkotlin.e06.rest_services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityRestServicesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestServicesActivity : AppCompatActivity() {

    lateinit var binding: ActivityRestServicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitConfig = RetrofitConfig.getInstance()
        val service = retrofitConfig.getGitHubService()

        binding.btnFind.setOnClickListener {

            var searchUsername = binding.txtUsername.text.toString()

            val gitHubCall: Call<GitHubUser> = service.getUser(searchUsername)

            gitHubCall.enqueue(object : Callback<GitHubUser>{

                override fun onResponse(call: Call<GitHubUser>, response: Response<GitHubUser>) {

                    val user = response.body() as GitHubUser
                    binding.name.text = user.name
                    binding.bio.text = user.bio
                    binding.blog.text = user.blog
                    binding.email.text = user.email ?: "email: "
                    binding.enterprise.text = user.company
                    binding.local.text = user.location
                    binding.repoNum.text = user.repos.toString()
                    binding.followNum.text = user.followers.toString()
                    binding.login.text = user.login

                }

                override fun onFailure(call: Call<GitHubUser>, t: Throwable) {
                    Log.d("User", "No Found")
                    Toast.makeText(applicationContext, "Erro durante a requisição", Toast.LENGTH_SHORT).show()
                }

            })


        }


    }
}