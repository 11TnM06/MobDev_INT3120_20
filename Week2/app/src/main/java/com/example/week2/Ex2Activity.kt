package com.example.week2

import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ex2Activity : AppCompatActivity() {
    private lateinit var btnReturnMain: Button
    private lateinit var numberPickerNumber: NumberPicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)
        // Return main button
        btnReturnMain = findViewById(R.id.btnReturnMain)
        btnReturnMain.setOnClickListener {
            onBackPressed()
        }

        // Pick Number in NumberPicker
        numberPickerNumber = findViewById(R.id.numberPicker)
        numberPickerNumber.setMinValue(0)
        numberPickerNumber.setMaxValue(1000)

    }
}