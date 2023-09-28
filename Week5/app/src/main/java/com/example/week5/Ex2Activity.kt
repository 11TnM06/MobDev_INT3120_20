package com.example.week5

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ex2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSave: Button
    private lateinit var btnClear: Button
    private lateinit var btnShow: Button

    private lateinit var inPassword: EditText
    private lateinit var inUserName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        btnSave = findViewById(R.id.btnSave)
        btnSave.setOnClickListener(this)
        btnClear = findViewById(R.id.btnClear)
        btnClear.setOnClickListener(this)
        btnShow = findViewById(R.id.btnShow)
        btnShow.setOnClickListener(this)

        inPassword = findViewById(R.id.inPassword)
        inUserName = findViewById(R.id.inUserId)

    }

    override fun onClick(v: View?) {
        var prefs = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = prefs.edit()
        when (v?.id) {
            R.id.btnSave -> {
                myEdit.putString("username", inUserName.text.toString())
                myEdit.putString("password", inPassword.text.toString())
                myEdit.apply()
                Log.d("manh", "save successfully")
            }
            R.id.btnClear -> {
                myEdit.clear().commit()
                inUserName.setText("")
                inPassword.setText("")
                Log.d("manh", "clear successfully")

            }
            R.id.btnShow -> {
                val username = prefs.getString("username", "")
                val password = prefs.getString("password", "")
                Toast.makeText(this, "password of user $username is $password", Toast.LENGTH_SHORT ).show()
                Log.d("manh", "show successfully")
            }
        }
    }


}
