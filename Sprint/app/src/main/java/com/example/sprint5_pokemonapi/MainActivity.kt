package com.example.sprint5_pokemonapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprint5_pokemonapi.model.Pokemon
import com.example.sprint5_pokemonapi.retro.Retrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(),retrofit2.Callback<Pokemon> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_get_pkmn.setOnClickListener {
            Retrofit.Showpkmn().enqueue(this)
        }
    }
}
