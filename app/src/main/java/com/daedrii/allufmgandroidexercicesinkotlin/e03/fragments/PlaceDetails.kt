package com.daedrii.allufmgandroidexercicesinkotlin.e03.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.daedrii.allufmgandroidexercicesinkotlin.databinding.FragmentPlaceDetailsBinding


class PlaceDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_details, container, false)
    }

    fun atualizaLugar(place: Place){
        val placePhoto = view?.findViewById<ImageView>(R.id.imgPlacePic)
        val lblTitle = view?.findViewById<TextView>(R.id.lblTitle)
        val lblComent = view?.findViewById<TextView>(R.id.lblComent)
        val rtBar = view?.findViewById<RatingBar>(R.id.ratingBar)
        val lblDistance = view?.findViewById<TextView>(R.id.lblDistance)

        placePhoto?.setImageResource(place.photoId ?: 0)
        lblTitle?.text = place.name
        lblComent?.text = place.description
        rtBar?.rating = place.rate ?: 0f
        lblDistance?.text = "${place.distance}Km"
    }


}