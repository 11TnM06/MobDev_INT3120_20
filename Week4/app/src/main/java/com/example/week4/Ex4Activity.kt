package com.example.week4

import android.content.Intent
import android.os.Bundle
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

        btnSendMessage.setOnClickListener { sendMessage(); }
    }
    private fun sendMessage() {
        var fullName = editText.text.toString()
        var message: String = "Hello, Please say hello me!"

        val intent = Intent(this, Ex4GreetingActivity::class.java)
        intent.putExtra("fullName", fullName)
        intent.putExtra("message", message)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivityForResult(intent, myRequestCode)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == myRequestCode) {
            if (resultCode == RESULT_OK) {
                val feedback = data?.getStringExtra("feedback")
                textView.text = feedback
            }
        }
    }
}