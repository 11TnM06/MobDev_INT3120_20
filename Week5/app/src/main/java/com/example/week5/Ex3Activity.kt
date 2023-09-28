package com.example.week5

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.util.Locale


class Ex3Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var read: Button
    private lateinit var write: Button
    private lateinit var userInput: EditText
    private lateinit var fileContent: TextView
    private val filename = "hello_world.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal)
        read = findViewById(R.id.read_button)
        write = findViewById(R.id.write_button)
        userInput = findViewById(R.id.userInput)
        fileContent = findViewById(R.id.content)
        read.setOnClickListener(this)
        write.setOnClickListener(this)
    }
    private fun printMessage(m: String?) {
        Toast.makeText(this, m, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View) {
        val btn = view as Button
        val btnText = btn.text.toString()
        when (btnText.lowercase(Locale.getDefault())) {
            "write" -> {
                writeData()
            }
            "read" -> {
                readData()
            }
        }
    }

    private fun writeData() {
        try {
            val fos = openFileOutput(filename, MODE_PRIVATE)
            val data = userInput.text.toString()
            fos.write(data.toByteArray())
            fos.flush()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        userInput.setText("")
        Toast.makeText(this, "Writing to file $filename completed...", Toast.LENGTH_SHORT).show()
    }

    private fun readData() {
        try {
            val fis = openFileInput(filename)
            var a: Int
            val sb = StringBuilder()
            while (fis.read().also { a = it } != -1) {
                sb.append(a.toChar())
            }

            fileContent.text = sb.toString()
            fis.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        Toast.makeText(this, "Reading to file $filename completed..", Toast.LENGTH_SHORT).show()
    }
}