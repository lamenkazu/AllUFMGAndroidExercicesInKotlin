package com.daedrii.allufmgandroidexercicesinkotlin.e05.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityIntentsCustomizadasBinding
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityIntentsNativasBinding

class IntentsCustomizadasActivity : AppCompatActivity() {

    lateinit var binding: ActivityIntentsCustomizadasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentsCustomizadasBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}