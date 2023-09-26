package com.example.week3

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.util.Calendar

class Ex13Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var fmtDateAndTime: DateFormat
    private lateinit var lblDateAndTime: TextView
    private val myCalendar = Calendar.getInstance()

    private val d = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
        myCalendar.set(Calendar.YEAR, year)
        myCalendar.set(Calendar.MONTH, monthOfYear)
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        updateLabel()
    }

    private val t = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
        myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        myCalendar.set(Calendar.MINUTE, minute)
        updateLabel()
    }
    private lateinit var btnDate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex13)
        fmtDateAndTime = DateFormat.getDateTimeInstance()
        lblDateAndTime = findViewById(R.id.lblDateAndTime)

        btnDate = findViewById(R.id.btnDate)
        btnDate.setOnClickListener(this)

        val btnTime = findViewById<Button>(R.id.btnTime)
        btnTime.setOnClickListener(this)

        updateLabel()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnDate -> {
                Log.d("manh", "button date")
                DatePickerDialog(
                    this, d,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
            R.id.btnTime -> {
                Log.d("manh", "button time")
                TimePickerDialog(
                    this, t,
                    myCalendar.get(Calendar.HOUR_OF_DAY),
                    myCalendar.get(Calendar.MINUTE), true
                ).show()
            }

            else -> {
                Log.d("Ex13Activity", "button error")
            }
        }
    }
    private fun updateLabel() {
        lblDateAndTime.text = fmtDateAndTime.format(myCalendar.time)
    }
}