package com.example.sprint5_pokemonapi


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint5_pokemonapi.API.PokiAPI
import com.example.sprint5_pokemonapi.retro.Retrofit
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_pkmn_list.*


class pkmnList : Fragment() {

internal lateinit var  recycler_view: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val itemView = inflater.inflate(R.layout.fragment_pkmn_list, container, false)

        recycler_view =itemView.findViewById(R.id.pkmn_recycle) as RecyclerView
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = GridLayoutManager(activity,2)
        return itemView

    }


}
