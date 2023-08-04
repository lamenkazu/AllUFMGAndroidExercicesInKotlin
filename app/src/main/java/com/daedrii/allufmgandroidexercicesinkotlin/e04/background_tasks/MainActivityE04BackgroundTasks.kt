package com.daedrii.allufmgandroidexercicesinkotlin.e04.background_tasks

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityMainE04BackgroundTasksBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivityE04BackgroundTasks : AppCompatActivity() {

    lateinit var binding: ActivityMainE04BackgroundTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainE04BackgroundTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDownload.setOnClickListener {
            binding.e04ProgressIndicator.visibility = View.VISIBLE
            coroutineDownload()
        }

    }

    private fun coroutineDownload() = GlobalScope.launch(Dispatchers.IO){
        try {
            val img: Bitmap? = downloadImage(binding.txtImgLink.text.toString())
            withContext(Dispatchers.Main){
                binding.imgPicture.setImageBitmap(img)

                binding.e04ProgressIndicator.visibility = View.GONE
            }

        }catch (e: IOException){
            Log.e("MainActivity", e.toString())

        }
    }

    private suspend fun downloadImage(imgLink: String) : Bitmap? {
        return withContext(Dispatchers.IO) {
            try {
                ImageDownloader.download(imgLink)
            } catch (e: IOException) {
                Log.e("MainActivity", e.toString())
                null
            }
        }
    }
}