package com.example.week5

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileInputStream
import java.io.IOException


class ViewInformationActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_information)
        textView = findViewById(R.id.textView_get_saved_data)
    }

    fun showPublicData(view: View?) {
        val folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val file = File(folder, "externalPublic.txt")
        val data = getData(file)
        if (data != null) {
            textView.text = data
        } else {
            textView.text = "No Data Found"
        }
    }

    fun showPrivateData(view: View?) {
        val folder = getExternalFilesDir("externalDir")
        val file = File(folder, "externalPrivate.txt")
        val data = getData(file)
        if (data != null) {
            textView.text = data
        } else {
            textView.text = "No Data Found"
        }
    }
    fun back(view: View?) {
        val intent = Intent(this@ViewInformationActivity, MainActivity::class.java)
        startActivity(intent)
    }

    private fun getData(myFile: File): String? {
        var fileInputStream: FileInputStream? = null
        try {
            fileInputStream = FileInputStream(myFile)
            var i = -1
            val buffer = StringBuffer()
            while (fileInputStream.read().also { i = it } != -1) {
                buffer.append(i.toChar())
            }
            return buffer.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return null
    }
}