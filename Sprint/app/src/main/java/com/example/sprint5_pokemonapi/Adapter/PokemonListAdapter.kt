package com.example.sprint5_pokemonapi.Adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint5_pokemonapi.model.Pokemon
import com.example.sprint5_pokemonapi.pkmnList

class PokemonListAdapter(internal  var context: Context, internal var pkmnList: List<Pokemon>):
    RecyclerView.Adapter<PokemonListAdapter.MyViewHolder> ()
{
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}