package com.example.week2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Relative2Activity : AppCompatActivity() {
    private lateinit var btnReturnMain: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative2)
        btnReturnMain = findViewById(R.id.btnReturnMain)
        btnReturnMain.setOnClickListener {
            onBackPressed()
        }
    }
}