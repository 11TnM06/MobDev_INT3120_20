package com.example.week5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week5.Users
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore

class Ex6Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)
        val userRef = Firebase.firestore.collection("users")
        userRef.whereEqualTo("email", "bro").get()
            .addOnSuccessListener { querySnapshot ->
                if (querySnapshot.isEmpty || querySnapshot.documents.isEmpty()) {
                    Toast.makeText(this, "Not success", Toast.LENGTH_SHORT).show()
                    return@addOnSuccessListener
                }
                for (document in querySnapshot.documents) {
                    val user = document.toObject(Users::class.java)
                    if (user?.email == "bro") {
                        Toast.makeText(this, user?.password, Toast.LENGTH_SHORT).show()
                    }
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Not success", Toast.LENGTH_SHORT).show()
            }
    }

}
