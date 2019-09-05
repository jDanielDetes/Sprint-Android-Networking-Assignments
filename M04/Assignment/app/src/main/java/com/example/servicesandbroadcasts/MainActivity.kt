package com.example.servicesandbroadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var imageReciever : BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            val serviceIntent = Intent(this,FileService::class.java)
            this.startService(serviceIntent)
        }
        imageReciever = object: BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                if (intent?.action == FileService.FILE_DOWNLOAD_ACTION) {
                    val bitmap = intent.getParcelableExtra<Bitmap>(FileService.DOWNLOADED_IMAGE)
                    imageView.setImageBitmap(bitmap)
                }
            }


        }

        val intentFilter = IntentFilter().apply {
            addAction(FileService.FILE_DOWNLOAD_ACTION)
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(imageReciever, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(imageReciever)
    }
}
