package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countries.Retrofit.OceaniaCountriesRetriever
import com.example.countries.model.OceaniaCountry
import javax.security.auth.callback.Callback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Callback<OceaniaCountry> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchCountriesButton.setOnClickListener {
            OceaniaCountriesRetriever().getOceaniaCountries().enqueue(this)

        }
    }
}
