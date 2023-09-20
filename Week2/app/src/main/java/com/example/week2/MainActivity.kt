package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var btnEx1Activity: Button
    private lateinit var btnEx2Activity: Button
    private lateinit var btnLinear1Activity: Button
    private lateinit var btnLinear2Activity: Button
    private lateinit var btnRelative1Activity: Button
    private lateinit var btnRelative2Activity: Button
    private lateinit var btnAbsoluteActivity: Button
    private lateinit var btnTableActivity: Button
    private lateinit var btnConstraintActivity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEx1Activity = findViewById(R.id.btnEx1)
        btnEx1Activity.setOnClickListener(this)
        btnEx2Activity = findViewById(R.id.btnEx2)
        btnEx2Activity.setOnClickListener(this)
        btnLinear1Activity = findViewById(R.id.btnLinear1)
        btnLinear1Activity.setOnClickListener(this)
        btnLinear2Activity = findViewById(R.id.btnLinear2)
        btnLinear2Activity.setOnClickListener(this)
        btnRelative1Activity = findViewById(R.id.btnRelative1)
        btnRelative1Activity.setOnClickListener(this)
        btnRelative2Activity = findViewById(R.id.btnRelative2)
        btnRelative2Activity.setOnClickListener(this)
        btnAbsoluteActivity = findViewById(R.id.btnAbsolute)
        btnAbsoluteActivity.setOnClickListener(this)
        btnTableActivity = findViewById(R.id.btnTable)
        btnTableActivity.setOnClickListener(this)
        btnConstraintActivity = findViewById(R.id.btnConstraint)
        btnConstraintActivity.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnEx1 -> {
                val intent = Intent(this@MainActivity, Ex1Activity::class.java)
                startActivity(intent)
            }
            R.id.btnEx2 -> {
                val intent = Intent(this@MainActivity, Ex2Activity::class.java)
                startActivity(intent)
            }
            R.id.btnLinear1 -> {
                val intent = Intent(this@MainActivity, Linear1Activity::class.java)
                startActivity(intent)
            }
            R.id.btnLinear2 -> {
                val intent = Intent(this@MainActivity, Linear2Activity::class.java)
                startActivity(intent)
            }
            R.id.btnRelative1 -> {
                val intent = Intent(this@MainActivity, Relative1Activity::class.java)
                startActivity(intent)
            }
            R.id.btnRelative2 -> {
                val intent = Intent(this@MainActivity, Relative2Activity::class.java)
                startActivity(intent)
            }
            R.id.btnAbsolute -> {
                val intent = Intent(this@MainActivity, AbsoluteActivity::class.java)
                startActivity(intent)
            }
            R.id.btnTable -> {
                val intent = Intent(this@MainActivity, TableActivity::class.java)
                startActivity(intent)
            }
            R.id.btnConstraint -> {
                val intent = Intent(this@MainActivity, ConstraintActivity::class.java)
                startActivity(intent)
            }
            else -> {
                print("button error")
            }
        }
    }
}