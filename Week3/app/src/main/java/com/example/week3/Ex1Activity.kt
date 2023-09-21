package com.example.week3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Ex1Activity : AppCompatActivity() {
    private lateinit var btnReturnMain: Button
    private val mobileArray = arrayOf(
        "Android", "IPhone", "WindowsMobile",
        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex1)
        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mobileArray)
        listView.adapter = adapter
        btnReturnMain = findViewById(R.id.btnReturnMain)
        btnReturnMain.setOnClickListener {
            onBackPressed()
        }
    }
}