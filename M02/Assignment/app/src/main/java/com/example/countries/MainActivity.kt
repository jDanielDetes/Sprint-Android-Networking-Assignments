package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.countries.Retrofit.OceaniaCountriesRetriever
import com.example.countries.model.OceaniaModelList
import javax.security.auth.callback.Callback
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), retrofit2.Callback<List<OceaniaModelList>>{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fetchCountriesButton.setOnClickListener {
            OceaniaCountriesRetriever().getOceaniaCountries().enqueue(this)
        }

    }

    override fun onResponse(
        call: Call<List<OceaniaModelList>>,
        response: Response<List<OceaniaModelList>>
    ) {

        if (response.isSuccessful) {
            val OceanModelList = response.body()
            for(element in OceanModelList!!) {
                countriesTextView.append(element.capital + ", ")
            }
            countriesTextView.text = ""
        }else {
            val response = "response was not successful; ${response.errorBody().toString()}"
            Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()

        }

    }

    override fun onFailure(call: Call<List<OceaniaModelList>>, t: Throwable) {
        t.printStackTrace()
        val response="failure; ${t.printStackTrace()}"
        Toast.makeText(this@MainActivity, response,Toast.LENGTH_SHORT).show()



    }

}
