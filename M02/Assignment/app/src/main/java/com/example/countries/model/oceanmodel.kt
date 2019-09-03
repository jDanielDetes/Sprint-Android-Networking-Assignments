package com.example.countries.model

data class oceanmodel {
    val country: List<OceaniaCountry>

}


data class OceaniaCountry (
    val name: String,
    val alpha2Code: String,
    val alpha3Code: String,
    val callingCodes: Int,
    val capital: String,
    val region : String,
    val subregion: String,
    val population: Int



)