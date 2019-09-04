package com.example.countries.Retrofit


import com.example.countries.model.OceaniaCountry
import com.example.countries.model.OceaniaModelList
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OceaniaCountriesRetriever {

    companion object {

        internal const val BASE_URL = "https://restcountries.eu/rest/v2/"
    }

    fun getOceaniaCountries(): Call<List<OceaniaModelList>> {
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