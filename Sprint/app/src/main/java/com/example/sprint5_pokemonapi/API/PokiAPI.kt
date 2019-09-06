package com.example.sprint5_pokemonapi.API

import com.example.sprint5_pokemonapi.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface PokiAPI {

    @GET("pokemon")
    fun getpkmnList() : Call<Pokemon>
}