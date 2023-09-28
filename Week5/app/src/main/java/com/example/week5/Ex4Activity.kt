package com.example.week5

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import android.Manifest;


class Ex4Activity : AppCompatActivity() {
    private val EXTERNAL_STORAGE_PERMISSION_CODE = 23
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external)
        editText = findViewById(R.id.editText_data)
    }

    fun savePublicly(view: View?) {
        // Requesting Permission to access External Storage
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            EXTERNAL_STORAGE_PERMISSION_CODE
        )
        val editTextData = editText.text.toString()
        val folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        val file = File(folder, "externalPublic.txt")
        writeTextData(file, editTextData)
        editText.setText("")
    }

    fun savePrivately(view: View?) {
        val editTextData = editText.text.toString()

        val folder = getExternalFilesDir("externalDir")
        val file = File(folder, "externalPrivate.txt")
        writeTextData(file, editTextData)
        editText.setText("")
    }

    fun viewInformation(view: View?) {
        val intent = Intent(this, ViewInformationActivity::class.java)
        startActivity(intent)
    }
    private fun writeTextData(file: File, data: String) {
        var fileOutputStream: FileOutputStream? = null
        try {
            fileOutputStream = FileOutputStream(file)
            fileOutputStream.write(data.toByteArray())
            Toast.makeText(this, "Done" + file.absolutePath, Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}