package com.daedrii.allufmgandroidexercicesinkotlin.e04.menu_and_navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.MenuItemCompat
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar?.title = "Second Activity"

        binding.btnGoToThird.setOnClickListener {
            val goToThirdIntent = Intent(this, ThirdActivity::class.java)
            startActivity(goToThirdIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.eo4_second_activity_menu, menu)

        //Implementação do SearchView
        val searchItem: MenuItem = menu?.findItem(R.id.actionFind) as MenuItem
        val searchView: SearchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext, "Buscando: ${query}", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
                return false
            }

        })


        //Implementação do ShareProvider
        val shareItem: MenuItem = menu.findItem(R.id.actionShare)
        val shareProvider = MenuItemCompat.getActionProvider(shareItem) as ShareActionProvider

        //Cria Intent que será exibida pelo Provider
        var providerIntent = Intent(Intent.ACTION_SEND)
        providerIntent.type = "text/*"
        providerIntent.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar")

        shareProvider.setShareIntent(providerIntent)

        return super.onCreateOptionsMenu(menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val alertBuilder = AlertDialog.Builder(this)


        when(item.itemId){
            R.id.actionRefresh -> {
                Toast.makeText(this,  "Atualizando...", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.actionAbout -> {
                alertBuilder.setTitle("Sobre:")
                alertBuilder.setMessage("Aplicativo sobre os conceitos de ActionBar e suas funcionalidades principais")
                alertBuilder.setPositiveButton("Beleza!"){dialog, _ -> }

                alertBuilder.create().show()

                return true
            }

            R.id.actionLeave -> {
                alertBuilder.setTitle("Sair")
                alertBuilder.setMessage("Quer mesmo sair do aplicativo?")

                alertBuilder.setPositiveButton("Sim!"){dialog, _ ->

                    this.finishAffinity() //Código para encerrar o aplicativo !!*****
                }
                alertBuilder.setNegativeButton("Não, quero ficar"){dialog, _ ->
                    Toast.makeText(this, "Que bom que decidiu ficar :D", Toast.LENGTH_SHORT).show()
                }

                alertBuilder.create().show()

                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}