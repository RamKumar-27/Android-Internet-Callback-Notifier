package com.example.calibraint.internetnotifier

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        hello_world.text=if(isConnected)"Online" else "Offline"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val action: String? = intent?.action
        val data: Uri? = intent?.data
        Log.i("log",data.toString())
    }

    override fun onResume() {
        super.onResume()

        NotifierApplication.getInstance().setConnectivityListener(this)

    }
}
