package com.example.calibraint.internetnotifier

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class ConnectivityReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val status = NetworkUtil.getConnectivityStatusString(context);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (status == NetworkUtil.NETWORK_STATUS_NOT_CONNECTED) {
                connectivityReceiverListener!!.onNetworkConnectionChanged(false)
            } else {
                connectivityReceiverListener!!.onNetworkConnectionChanged(true)
            }
        }
    }


    interface ConnectivityReceiverListener {
        fun onNetworkConnectionChanged(isConnected: Boolean)

    }

    companion object {
        var connectivityReceiverListener: ConnectivityReceiverListener? = null
    }
}