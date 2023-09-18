package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var btnEx1Activity: Button
    private lateinit var btnEx2Activity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEx1Activity = findViewById(R.id.btnEx1)
        btnEx1Activity.setOnClickListener(this)

        btnEx2Activity = findViewById(R.id.btnEx2)
        btnEx2Activity.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnEx1 -> {
                val intent = Intent(this@MainActivity, Ex1Activity::class.java)
                startActivity(intent)
            }
            R.id.btnEx2 -> {
                val intent = Intent(this@MainActivity, Ex2Activity::class.java)
                startActivity(intent)
            }
            else -> {
                print("button error")
            }
        }
    }
}