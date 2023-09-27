package com.example.week4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ex4Activity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var btnSendMessage: Button
    private lateinit var textView: TextView
    private var myRequestCode = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4_main)

        btnSendMessage = findViewById(R.id.btnSendMessage)
        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView3)

        btnSendMessage.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                sendMessage();
            }

        })
    }
    private fun sendMessage() {
        var fullName = editText.text.toString()
        var message: String = "Hello, Please say hello me!"

        val intent = Intent(this, Ex4GreetingActivity::class.java)
        intent.putExtra("fullName", fullName)
        intent.putExtra("message", message)

        startActivity(intent)
    }
}