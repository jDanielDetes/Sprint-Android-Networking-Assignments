package com.example.servicesandbroadcasts

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.lang.UnsupportedOperationException

class FileService : Service(){

    companion object {

        const val FILE_DOWNLOAD_ACTION= "com.example.servicesandbroadcasts.FILE_DOWNLOADED"
        const val DOWNLOADED_IMAGE = "downloadedImage"
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Thread(Runnable(){
            val bitmap= NetworkAdapter.getBitmapFromUrl("https://i.imgur.com/HaSmgGn.jpg")

            val intent = Intent(FILE_DOWNLOAD_ACTION).apply{
                putExtra(DOWNLOADED_IMAGE,bitmap)

            }
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            stopSelf()





        }).start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        throw UnsupportedOperationException()
    }
}