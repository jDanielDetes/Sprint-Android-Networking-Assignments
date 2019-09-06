package com.example.sprint5_pokemonapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sprint5_pokemonapi.R
import com.example.sprint5_pokemonapi.model.Pokemon
import com.example.sprint5_pokemonapi.pkmnList
import kotlinx.android.synthetic.main.pkmn_list_view.view.*

class PokemonListAdapter(internal  var context: Context, internal var pkmnList: List<Pokemon>):
    RecyclerView.Adapter<PokemonListAdapter.MyViewHolder> ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.pkmn_list_view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return pkmnList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(pkmnList[position].sprites).into(holder.image_pkmn)
        holder.text_pkmn.text = pkmnList[position].name
    }

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        internal var image_pkmn: ImageView = itemView.findViewById(R.id.pkmn_image) as ImageView
        internal var text_pkmn: TextView = itemView.findViewById(R.id.pkmn_name) as TextView
    }
}