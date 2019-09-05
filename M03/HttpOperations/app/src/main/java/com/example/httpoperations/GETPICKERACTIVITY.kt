package com.example.httpoperations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_getpickeractivity.*
import kotlinx.android.synthetic.main.activity_main.*

class GETPICKERACTIVITY : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getpickeractivity)


        btn_simpleget.setOnClickListener {
            val intent= Intent(this@GETPICKERACTIVITY,GETACTIVITY::class.java)
            intent.putExtra("get","simple")
            startActivity(intent)

        }
    }
}
