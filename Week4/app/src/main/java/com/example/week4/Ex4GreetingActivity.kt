package com.example.week4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ex4GreetingActivity : AppCompatActivity() {
    private lateinit var btnBack : Button
    private lateinit var textViewMessage: TextView
    private var fullName: String? = null
    private var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4_greeting)

        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener { onBackPressed() }
        textViewMessage = findViewById(R.id.textView_message)
        fullName = intent.getStringExtra("fullName")
        message = intent.getStringExtra("message")
        textViewMessage.text = message
    }

    override fun finish() {
        val data = Intent()
        val feedback = "OK, Hello $fullName. How are you?"
        data.putExtra("feedback", feedback)
        setResult(Activity.RESULT_OK, data)
        super.finish()
    }

}