package com.daedrii.allufmgandroidexercicesinkotlin.e02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityE02ActivityBinding

class E02Activity : DebugActivity() {

    lateinit var binding: ActivityE02ActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityE02ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val login = intent.extras?.getString("Login")

        binding.username.text = "Usuario Logado: $login"
    }
}