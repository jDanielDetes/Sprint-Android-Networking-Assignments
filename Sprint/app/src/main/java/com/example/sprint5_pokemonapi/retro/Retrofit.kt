package com.example.sprint5_pokemonapi.retro

import com.example.sprint5_pokemonapi.API.PokiAPI
import com.example.sprint5_pokemonapi.model.Pokemon
import com.google.gson.GsonBuilder
import io.reactivex.internal.schedulers.RxThreadFactory
import io.reactivex.plugins.RxJavaPlugins
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    private const val  BASE_URL = "http://pokeapi.co/api/v2/"

    fun Showpkmn() : Call<Pokemon> {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(PokiAPI::class.java).getpkmnList()

    }
}