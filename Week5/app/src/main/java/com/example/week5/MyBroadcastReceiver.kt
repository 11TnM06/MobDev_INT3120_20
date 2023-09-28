package com.example.week5

import android.content.BroadcastReceiver
import android.widget.Toast


class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: android.content.Context?, intent: android.content.Intent?) {
        val message = intent!!.getStringExtra("message")
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}