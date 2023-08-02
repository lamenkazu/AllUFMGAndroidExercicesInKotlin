package com.daedrii.allufmgandroidexercicesinkotlin.e03.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.ListFragment
import com.daedrii.allufmgandroidexercicesinkotlin.R


class PlacesListFragment : ListFragment() {

    private val lugares = arrayOf(
        Place("Machu Picchu", "Cidade histórica do povo Inca", R.drawable.ic_machu_picchu, 3133.98, 4f),
        Place("Alhambra", "Palácio árabe na cidade de Granada, ESP.", R.drawable.ic_alhambra, 7626.22, 5f),
        Place("Bariloche", "Cidade turística ao sudoeste da Argentina", R.drawable.ic_bariloche, 3498.84, 4f),
        Place("Coliseu", "Lugar de grandes espetáculos na época do Império Romano", R.drawable.ic_coliseu, 9318.41, 5f),
        Place("Muralha da China", "Simplesmente a maior muralha do mundo!", R.drawable.ic_muralha_china, 17105.55, 3.5f)

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_places_list, container, false)

        val adapter = PlaceAdapter(requireActivity(), lugares)
        listAdapter = adapter

        return view
    }


    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        val lugarSelecionado = lugares[position]

        // TODO[4]: Recuperar PlaceFragment e atualizar o lugar

        val manager: FragmentManager = this.requireActivity().supportFragmentManager
        val placeFragment: PlaceDetails = manager.findFragmentById(R.id.frag_place_details) as PlaceDetails

        placeFragment.atualizaLugar(lugarSelecionado)
    }

}