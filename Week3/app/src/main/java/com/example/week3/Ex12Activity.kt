package com.example.week3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ex12Activity: AppCompatActivity(), View.OnClickListener {
    private lateinit var btnReturnMain: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex12)
        btnReturnMain = findViewById(R.id.btnReturnMain)
        btnReturnMain.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnReturnMain -> {
                Log.d("manh", "on click return ")
                onBackPressed()
            }

            else -> {
                print("button error")
            }
        }
    }
}