package com.daedrii.allufmgandroidexercicesinkotlin.e03.layout_and_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.daedrii.allufmgandroidexercicesinkotlin.R

class MainActivityE03Adapter : AppCompatActivity() {

    lateinit var lvPlaces: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_e03_adapter)

        val adapter = PlaceAdapter(this.applicationContext)

        lvPlaces = findViewById(R.id.lvPlaces)

        lvPlaces.adapter = adapter
    }
}