package com.daedrii.allufmgandroidexercicesinkotlin.e06.data_percistence.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityDatabaseBinding

class DatabaseActivity : AppCompatActivity() {

    lateinit var binding: ActivityDatabaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productDAO = ProductDAO(this)

        productDAO.insert(
            Product(0,"Banana", 7.99)
        )
        productDAO.insert(
            Product(1, "Bala Halls", 3.0)
        )

        val productList: ArrayList<Product> = productDAO.getAll()

        productList.forEach{
            Log.d("Product ID", "ID: ${it.id} Name: ${it.name}, Price: R$${it.price}")
        }

        productDAO.deleteAll()


        productList.forEach{
            Log.d("Product ID", "ID: ${it.id} Name: ${it.name}, Price: R$${it.price}")
        }
    }
}