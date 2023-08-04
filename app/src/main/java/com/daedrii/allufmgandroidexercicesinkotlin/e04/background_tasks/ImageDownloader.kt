package com.daedrii.allufmgandroidexercicesinkotlin.e04.background_tasks

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException
import java.net.URL

class ImageDownloader {

    companion object {
        @Throws(IOException::class)
        fun download(url: String) : Bitmap {

            var bitmap: Bitmap

            val inputStream = URL(url).openStream()
            bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()

            return bitmap

        }
    }





}