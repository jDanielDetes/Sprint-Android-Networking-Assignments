package com.example.countries.Retrofit

import android.telecom.Call

import com.example.countries.model.oceanmodel
import retrofit2.http.GET

interface OceaniaCountriesAPI {

    @GET("rest/v2/region/Oceania")
    fun getCountries(): Call<oceanmodel>
}