package com.daedrii.allufmgandroidexercicesinkotlin.e05.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityIntentsCustomizadasBinding
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityIntentsNativasBinding

class IntentsCustomizadasActivity : AppCompatActivity() {

    lateinit var binding: ActivityIntentsCustomizadasBinding

    private val scanResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK){

            val code: String = result.data?.getStringExtra("SCAN_RESULT") as String
            binding.lblCode.text = code

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentsCustomizadasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScan.setOnClickListener {
            val scanIntent = Intent("com.google.zxing.client.android.SCAN")

            scanResult.launch(scanIntent)
        }
    }
}