package com.daedrii.allufmgandroidexercicesinkotlin.e03.layout_and_adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.content.Context;
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.daedrii.allufmgandroidexercicesinkotlin.R

class PlaceAdapter(private val context: Context): BaseAdapter() {

    private val places: MutableList<Place> = ArrayList()

    init{
        carregaLista()
    }

    private fun carregaLista(){
        this.places.add(Place("Rua do Ouro", R.drawable.ic_launcher_background, 2.4, 3.5F, "rua esquisita ali do bairro"))
        this.places.add(Place("Praça da Liberdade", R.drawable.ic_launcher_foreground, 6.4, 4.0F, "Praça famosa de bh"))
    }

    override fun getCount(): Int {
        return this.places.size
    }

    override fun getItem(position: Int): Any {
        return this.places.get(position)
    }

    override fun getItemId(position: Int): Long {
        val place: Place = this.places[position]
        return place.photoId?.toLong() ?: -1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val atual = this.places[position]

        val placeView = LayoutInflater.from(context)
            .inflate(R.layout.list_item_place, parent, false)

        val placePhoto = placeView.findViewById<ImageView>(R.id.img_place_photo)
        val placeName  = placeView.findViewById<TextView>(R.id.txt_place_name)
        val placeDescription = placeView.findViewById<TextView>(R.id.txt_place_description)
        val rtBar = placeView.findViewById<RatingBar>(R.id.rating_place_vote)
        val placeDistance = placeView.findViewById<TextView>(R.id.txt_place_distance)

        placePhoto.setImageResource(atual.photoId ?: 0)
        placeName.text = atual.name
        placeDescription.text = atual.description
        rtBar.rating = atual.rate ?: 0f
        placeDistance.text = "${atual.distance}Km"

        return placeView
    }
}
