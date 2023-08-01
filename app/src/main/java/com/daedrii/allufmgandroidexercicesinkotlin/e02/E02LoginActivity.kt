package com.daedrii.allufmgandroidexercicesinkotlin.e02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityE02LoginBinding

class E02LoginActivity : DebugActivity() {
    private lateinit var binding: ActivityE02LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityE02LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogIn.setOnClickListener{

            val login = binding.login.text.toString()
            val password = binding.password.text.toString()

            if(login.equals("admin") && password.equals("admin123")){
                val intent = Intent(this, E02Activity::class.java).apply {
                    putExtra("Login", login)
                    putExtra("Password", password)
                }
                startActivity(intent)
                Toast.makeText(this, "Login feito com sucesso", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Dados incorretos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}