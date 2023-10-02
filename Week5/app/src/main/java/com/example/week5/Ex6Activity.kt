package com.example.week5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage


class Ex6Activity : AppCompatActivity() {

    private lateinit var storage: FirebaseStorage
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var storageRef = storage.reference;

        btn = findViewById(R.id.button)
        btn.setOnClickListener {
            uploadImage()
        }
    }
    private fun uploadImage() {
        var storageRef = storage.reference;
        var imageRef = storageRef.child("image.jpg");
        var imageUri = imageRef.downloadUrl;
    }

}
