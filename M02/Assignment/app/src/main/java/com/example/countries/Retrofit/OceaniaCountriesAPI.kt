package com.example.countries.Retrofit

import android.telecom.Call



import com.example.countries.model.OceaniaModelList
import retrofit2.http.GET

interface OceaniaCountriesAPI {

    @GET("regionalbloc/eu")
    fun getCountries(): retrofit2.Call<List<OceaniaModelList>>
}