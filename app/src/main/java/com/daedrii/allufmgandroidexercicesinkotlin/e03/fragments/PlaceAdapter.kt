package com.daedrii.allufmgandroidexercicesinkotlin.e03.fragments

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PlaceAdapter(private val context: Context, private val lugares: Array<Place> ): BaseAdapter() {

    override fun getCount(): Int {
        return lugares.size
    }

    override fun getItem(position: Int): Any {
        return lugares[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val lugar: Place = this.lugares[position]

        var txtNome = TextView(context)
        txtNome.text = lugar.name

        return txtNome
    }
}