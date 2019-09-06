package com.example.sprint5_pokemonapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprint5_pokemonapi.model.Pokemon
import com.example.sprint5_pokemonapi.retro.Retrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(),retrofit2.Callback<Pokemon> {
    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            Retrofit.Showpkmn().enqueue(this)
        }
    }

