package com.example.week4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ex5Activity : AppCompatActivity() {
    private lateinit var sendButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex5)
        sendButton = findViewById(R.id.sendButton)

        // send button on click listener
        sendButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND) // intent
//            intent.type = "text/plain"
//            intent.putExtra(Intent.EXTRA_EMAIL, "hoangducmanh123@gmail.com")
//            intent.putExtra(Intent.EXTRA_SUBJECT, "This is a dummy message")
//            intent.putExtra(Intent.EXTRA_TEXT, "Dummy test message")
            startActivity(intent)
        }
    }
}