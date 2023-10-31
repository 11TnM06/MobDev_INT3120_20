package com.example.week6

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Ex2Activity : AppCompatActivity() {
    private lateinit var btnForeground: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)
        btnForeground = findViewById(R.id.btnForeground)
        btnForeground.setOnClickListener {
            val serviceIntent = Intent(this, MyForegroundService::class.java)
            ContextCompat.startForegroundService(this, serviceIntent)
        }
    }
}
