package com.daedrii.allufmgandroidexercicesinkotlin.e06.data_percistence.files

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivityFilesBinding
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.lang.RuntimeException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

class FilesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilesBinding

    private val SHARE_PREF_ID = "SharedPrefId"
    private val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
    private var actualDate: String

    private val takePhotoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            val data = it.data

            data?.let{
                val photo = it.extras?.get("data") as Bitmap
                binding.img.setImageBitmap(photo)
            }
        }
    }

    init{
        sdf.timeZone = TimeZone.getTimeZone("America/Sao_Paulo")
        actualDate = sdf.format(Date())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        saveAccessTime()

        setButtonsAction()

    }

    private fun setButtonsAction(){
        //Ação de Tirar a foto e armazena-la no componente ImageView
        binding.btnTake.setOnClickListener {
            val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePhotoLauncher.launch(takePhotoIntent)
        }

        //Ação de Salvar a Imagem no armazenamento Externo
        binding.btnSaveExternal.setOnClickListener {
            val drawable = binding.img.drawable

            drawable?.let{
                val bitmapDrawable = binding.img.drawable as BitmapDrawable
                val bitmap = bitmapDrawable.bitmap
                val path = baseContext.getExternalFilesDir(null).toString() //Obtém o diretório de arquivos externos do dispositivo
                Log.d("path img", path)
                val file = File(path, "image.jpg")

                if(Environment.getExternalStorageState(file).equals(Environment.MEDIA_MOUNTED))
                    savePhoto(bitmap, file)
                else Toast.makeText(applicationContext, "Armazenamento Externo Indisponível", Toast.LENGTH_SHORT).show()

            } ?: run{
                Toast.makeText(applicationContext, "Não há foto para salvar", Toast.LENGTH_SHORT).show()

            }
        }

        //Ação de Salvar a Imagem no armazenamento Interno
        binding.btnSaveInternal.setOnClickListener {
            val drawable = binding.img.drawable

            drawable?.let{
                val bitmapDrawable = binding.img.drawable as BitmapDrawable
                val bitmap = bitmapDrawable.bitmap

                val fileDir = applicationContext.filesDir //Obtém o diretório de arquivos internos do aplicativo
                val fileName = "image.jpg"
                val file = File(fileDir, fileName)

                savePhoto(bitmap, file)
            } ?: run{
                Toast.makeText(applicationContext, "Não há foto para salvar", Toast.LENGTH_SHORT).show()
            }

        }


    }

    //Utilização do SharedPreferences
    private fun saveAccessTime(){
        val pref = applicationContext.getSharedPreferences(SHARE_PREF_ID, 0) as SharedPreferences
        val editor = pref.edit() as SharedPreferences.Editor

        val value = pref.getString("last_access", "")

        value?.let {// if(!value.isEmpty())
            binding.lblAccess.text = "Ultimo Acesso: "
            binding.lblTime.text = it //it = (value)
        } ?: run{
            binding.lblAccess.text = "Primeiro acesso"

        }

        editor.putString("last_access", actualDate)
        editor.apply() //apply() é assíncrono, substituindo o commit() que é sícnrono

    }

    //Método que salva arquivo no dispositivo
    private fun savePhoto(bitmap: Bitmap, file: File){

        try{
            val out = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
            out.flush()
            out.close()
            Toast.makeText(applicationContext, "Foto Salva", Toast.LENGTH_SHORT).show()
        }catch (e: IOException){
            throw RuntimeException(e)
        }

    }


}