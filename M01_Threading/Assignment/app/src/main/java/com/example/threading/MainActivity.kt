package com.example.threading

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            progressBar.progress = 3
            progressBar.visibility = View.VISIBLE
            MyAsyncTask().execute()
        }
    }

    fun primes(): Sequence<Long> {
        var i = 0L
        return sequence {
            generateSequence { i++ }
                .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
                .forEach { yield(it) }
        }
    }

    inner class MyAsyncTask : AsyncTask<Unit, Int, String>() {

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            progressBar.visibility = View.GONE
            text_view.text = result

            button.text = "Generate"
        }

        override fun doInBackground(vararg p0: Unit?): String {
            fun primes(): Sequence<Long> {
                var i = 0L
                return sequence {
                    generateSequence { i++ }
                        .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
                        .forEach { yield(it) }
                }
            }
            val primeNumbers = primes().take(160).joinToString(", ")
            return primeNumbers
        }
        override fun onCancelled() {
            super.onCancelled()
        }

        override fun onPreExecute() {
            super.onPreExecute()
            text_view.text = "Loading..."
        }
    }
}


