package com.example.week3

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ex7Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnReturnMain: Button
    private lateinit var btnDonate: Button
    private lateinit var numberPickerNumber: NumberPicker
    private lateinit var editText: EditText
    private lateinit var tvContentText3: TextView
    private lateinit var progressBar: ProgressBar
    private var dwTotal = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex7)
        // Return main button
        btnReturnMain = findViewById(R.id.btnReturnMain)
        btnReturnMain.setOnClickListener(this)
        // Donate button
        btnDonate = findViewById(R.id.btnDonate)
        btnDonate.setOnClickListener(this)
        // Pick Number in NumberPicker
        numberPickerNumber = findViewById(R.id.numberPicker)
        numberPickerNumber.minValue = 0
        numberPickerNumber.maxValue = 1000
        // Find id of text view and edit text
        tvContentText3 = findViewById(R.id.tvContent3)
        editText = findViewById(R.id.editText)
        // Find id of Progress bar
        progressBar = findViewById(R.id.progressBarHorizontal)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnReturnMain -> {
                onBackPressed()
            }

            R.id.btnDonate -> {
                calculateTotal()
                processBar()
            }

            else -> {
                print("button error")
            }
        }
    }

    private fun calculateTotal() {
        // get content of edit text
        val sAmount = editText.text.toString()
        var dwAmount: Int
        try {
            dwAmount = sAmount.toInt()
        } catch (e: NumberFormatException) {
            dwAmount = 0
            print("Money edit box received wrong format number\n")
        }
        dwTotal += dwAmount + numberPickerNumber.value
    }

    fun displayTotal() {
        editText.text.clear()
        val total = dwTotal.toString()
        tvContentText3.text = "Total so far $$total"
    }

    fun processBar() {
        btnDonate.isEnabled = false
        progressBar.visibility = View.VISIBLE
        val handler = Handler(Looper.getMainLooper())
        var progress = 0

        handler.postDelayed(object : Runnable {
            override fun run() {
                if (progress < 100) {
                    progress++
                    progressBar.progress = progress
                    handler.postDelayed(this, 10) // Adjust the delay as needed
                } else {
                    // Progress reached 100%, hide the progress bar and enable the button
                    progressBar.visibility = View.INVISIBLE
                    btnDonate.isEnabled = true
                    displayTotal()
                }
            }
        }, 50)
    }
}