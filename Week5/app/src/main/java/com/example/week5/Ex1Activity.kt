package com.example.week5

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class Ex1Activity : AppCompatActivity() {
    private lateinit var btnBroadCast: Button
    private val receiver = MyBroadcastReceiver()
    private val intentFilter = IntentFilter("com.example.ACTION_MY_EVENT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)
        btnBroadCast = findViewById(R.id.btnBroadcast)
        btnBroadCast.setOnClickListener {
            val intent = Intent("com.example.ACTION_MY_EVENT")
            intent.putExtra("message", "Hello, this is a broadcast event")
            sendBroadcast(intent)
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }


        registerReceiver(receiver, intentFilter)

    }

    override fun onStop() {
        super.onStop()
        try {
            unregisterReceiver(receiver)
            Log.d("manh", "unregister successfull")
        } catch (e: IllegalArgumentException) {
            Log.d("manh", "unregister failed")
        }
    }
}