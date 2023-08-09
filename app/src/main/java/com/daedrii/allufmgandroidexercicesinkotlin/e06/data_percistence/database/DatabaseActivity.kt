package com.daedrii.allufmgandroidexercicesinkotlin.e06.data_percistence.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityDatabaseBinding

class DatabaseActivity : AppCompatActivity() {

    lateinit var binding: ActivityDatabaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ProductAdapter(applicationContext)

        binding.productList.adapter = adapter

        binding.btnAddProduct.setOnClickListener {

            val productName = binding.txtProductName.text.toString()
            val productPrice = binding.txtProductPrice.text.toString().toDouble()
            val productSize = adapter.getProducts().size

            val newProduct = Product(productSize, productName, productPrice)

            adapter.insertProduct(newProduct)
        }

        binding.btnDelete.setOnClickListener{
            adapter.deleteProducts()
        }
    }
}