package com.example.week3

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ex2Activity : AppCompatActivity() {
    private lateinit var btnReturnMain: Button
    private lateinit var tvContent: TextView
    private val mobileArray = arrayOf(
        "Select an option", "Android", "IPhone", "WindowsMobile",
        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)
        tvContent = findViewById(R.id.selection)
        btnReturnMain = findViewById(R.id.btnReturnMain)
        btnReturnMain.setOnClickListener {
            onBackPressed()
        }
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mobileArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>) {
                tvContent.text = "xin chao"

            }
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle item selection
                val selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem == "Select an option") {
                    tvContent.text = ""
                }
                else {
                    tvContent.text = selectedItem
                }
            }


        }

    }
}