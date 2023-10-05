package com.example.week6

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ex1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex1)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        return true
    }

    fun onClickAddDetails(view: View?) {
        // class to add values in the database
        val values = ContentValues()
        // fetching text from user
        values.put(MyContentProvider.name, (findViewById<View>(R.id.textName) as EditText).text.toString())
        // inserting into database through content URI
        contentResolver.insert(MyContentProvider.CONTENT_URI, values)
        Toast.makeText(baseContext, "New Record Inserted", Toast.LENGTH_LONG).show()
    }

    fun onClickShowDetails(view: View?) {
        val resultView = findViewById<View>(R.id.res) as TextView
        val cursor = contentResolver.query(Uri.parse("content://com.demo.user.provider/users"), null, null, null, null)
        if (cursor!!.moveToFirst()) {
            val strBuild = StringBuilder()
            while (!cursor.isAfterLast) {
                val indexId = cursor.getColumnIndex("id")
                val indexName = cursor.getColumnIndex("name")
                strBuild.append("id:\t${cursor.getString(indexId)} - name:\t${cursor.getString(indexName)}".trimIndent())
                strBuild.append("\n")
                cursor.moveToNext()
            }
            resultView.text = strBuild
        } else {
            resultView.text = "No Records Found"
        }
    }
}