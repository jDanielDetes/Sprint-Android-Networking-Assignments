package com.example.countries.Retrofit

import com.example.countries.model.oceanmodel
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OceaniaCountriesRetriever {

    companion object {
        private const val TAG = "RETRIEVER"
        internal const val BASE_URL = "https://restcountries.eu/"
    }

    fun getOceaniaCountries(): Call<oceanmodel> {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val countriesAPI = retrofit.create(OceaniaCountriesAPI::class.java)
        return countriesAPI.getCountries()


    }
}