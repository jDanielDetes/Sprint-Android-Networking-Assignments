package com.example.sprint5_pokemonapi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.TIMEOUT
import com.example.sprint5_pokemonapi.model.Pokemon
import com.example.sprint5_pokemonapi.retro.Retrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

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
    fun getBitmapFromUrl(stringUrl: String, width:Int = 0, height:Int = 0): Bitmap? {
        var result: Bitmap? = null
        var stream: InputStream? = null
        var connection: HttpURLConnection? = null
        try {
            val url = URL(stringUrl)
            connection = url.openConnection() as HttpURLConnection


            connection.connect()

            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                stream = connection.inputStream
                if (stream != null) {
                    result = if (width > 0 && height > 0) {
                        Bitmap.createScaledBitmap(BitmapFactory.decodeStream(stream), width, height, true)
                    } else {
                        BitmapFactory.decodeStream(stream)
                    }
                }
            }

        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()

            if (stream != null) {
                try {
                    stream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
        return result
    }

}


