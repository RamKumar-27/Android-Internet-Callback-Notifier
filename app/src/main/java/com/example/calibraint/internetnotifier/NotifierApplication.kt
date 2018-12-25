package com.example.calibraint.internetnotifier

import android.app.Application
import android.content.IntentFilter
import android.os.Build

class NotifierApplication : Application() {


    companion object {
        private var mInstance: NotifierApplication? = null
        fun getInstance(): NotifierApplication = mInstance!!
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            val filter = IntentFilter()
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
            filter.addAction("android.net.wifi.WIFI_STATE_CHANGED")
            this.registerReceiver(ConnectivityReceiver(), filter)
        }
    }

    fun setConnectivityListener(listener: ConnectivityReceiver.ConnectivityReceiverListener) {
        ConnectivityReceiver.connectivityReceiverListener = listener
    }
}