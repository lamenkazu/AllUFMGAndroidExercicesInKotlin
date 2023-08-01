package com.daedrii.allufmgandroidexercicesinkotlin.e03.layouts_and_widgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityMainE03Binding

class MainActivityE03 : AppCompatActivity() {

    lateinit var binding: ActivityMainE03Binding

    fun btnClicks(){

        binding.formulario.setOnClickListener{
            val formIntent = Intent(this, FormActivity::class.java)
            startActivity(formIntent)
        }

        binding.noticia.setOnClickListener {
            val newsIntent = Intent(this, NewsActivity::class.java)
            startActivity(newsIntent)
        }

        binding.previsao.setOnClickListener {
            val weatherIntent = Intent(this, WeatherActivity::class.java)
            startActivity(weatherIntent)
        }

        binding.splash.setOnClickListener {
            val splashIntent = Intent(this, SplashActivity::class.java)
            startActivity(splashIntent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainE03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        btnClicks()


    }
}