package com.daedrii.allufmgandroidexercicesinkotlin.e05.intents

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityIntentsNativasBinding

class IntentsNativasActivity : AppCompatActivity() {

    lateinit var binding: ActivityIntentsNativasBinding

//  ¹ - ActivityForResult
    private val photoActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result: ActivityResult ->

            if(result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                var photo = data?.extras?.get("data") as Bitmap
                val ivPhoto = this.findViewById<ImageView>(R.id.imgProfile)

                ivPhoto.setImageBitmap(photo);
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentsNativasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonsActionImplementation()

    }

    private fun buttonsActionImplementation(){

        binding.btnEdit.setOnClickListener {

            val photoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

//          ² - Launch
            photoActivityResult.launch(photoIntent)


        }

        binding.profileMail.setOnClickListener {

            val sendMailIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_EMAIL, binding.profileMail.text.toString())
                type = "text/*"
            }

            val shareIntent = Intent.createChooser(sendMailIntent, null)
            startActivity(shareIntent)
        }

        binding.profileTel.setOnClickListener {

            val callUri = Uri.parse("tel:${binding.profileTel.text}")
            val callIntent = Intent(Intent.ACTION_DIAL, callUri)

            startActivity(callIntent)

        }

    }
}