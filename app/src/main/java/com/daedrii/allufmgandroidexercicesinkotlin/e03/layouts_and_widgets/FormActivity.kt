package com.daedrii.allufmgandroidexercicesinkotlin.e03.layouts_and_widgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    lateinit var binding: ActivityFormBinding


    private fun showConfirmDialog(){

        val alertBuilder = AlertDialog.Builder(this)

        //Define parametros para o Dialog
        alertBuilder.setTitle("Seus dados estão corretos?")
        alertBuilder.setMessage(
            "Nome: " + binding.name.text.toString() +
                    "\nEmail: " + binding.email.text.toString() +
                    "\nComentario: " + binding.coment.text.toString() +
                    "\nNota: " + binding.ratingBar.rating
        )

        alertBuilder.setPositiveButton("Estão!") {dialog, _ ->

            Toast.makeText(baseContext, "Dados Enviados", Toast.LENGTH_SHORT).show()
        }

        alertBuilder.setNegativeButton("Corrigir"){dialog, _ ->

            Toast.makeText(baseContext, "Corrija os dados", Toast.LENGTH_SHORT).show()
        }

        val dialog = alertBuilder.create()
        dialog.show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.confirmBtn.setOnClickListener {
            showConfirmDialog()
        }


    }
}