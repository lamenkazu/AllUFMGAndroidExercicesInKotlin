package com.daedrii.allufmgandroidexercicesinkotlin.e04.menu_and_navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityMainE04ActionBarBinding

class MainActivityE04ActionBar : AppCompatActivity() {

    lateinit var binding: ActivityMainE04ActionBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainE04ActionBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoToSecond.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}