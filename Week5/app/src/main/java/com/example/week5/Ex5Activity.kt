package com.example.week5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ex5Activity : AppCompatActivity() {
    private lateinit var enterAge : EditText
    private lateinit var enterName : EditText
    private lateinit var addName : Button
    private lateinit var printName : Button
    private lateinit var Name: TextView
    private lateinit var Age: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        addName = findViewById(R.id.addName)
        addName.setOnClickListener {

            val db = DBHelper(this, null)
            val name = enterName.text.toString()
            val age = enterAge.text.toString()

            db.addName(name, age)
            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()
            enterName.text.clear()
            enterAge.text.clear()
        }

        Name = findViewById(R.id.Name)
        Age = findViewById(R.id.Age)
        enterName = findViewById(R.id.enterName)
        enterAge = findViewById(R.id.enterAge)
        printName = findViewById(R.id.printName)
        printName.setOnClickListener {

            val db = DBHelper(this, null)
            val cursor = db.getName()

            cursor!!.moveToFirst()
            Name.text = ""
            Age.text = ""
            var indexName= cursor.getColumnIndex(DBHelper.NAME_COl)
            var indexAge= cursor.getColumnIndex(DBHelper.AGE_COL)
            if (cursor.getColumnIndex(DBHelper.NAME_COl) >= 0 && cursor.getColumnIndex(DBHelper.AGE_COL) >= 0) {

                Name.append(cursor.getString(indexName) + "\n")
                Age.append(cursor.getString(indexAge) + "\n")
            }

            while (cursor.moveToNext()) {
                indexName= cursor.getColumnIndex(DBHelper.NAME_COl)
                indexAge= cursor.getColumnIndex(DBHelper.AGE_COL)
                Name.append(cursor.getString(indexName) + "\n")
                Age.append(cursor.getString(indexAge) + "\n")
            }

            cursor.close()
        }
    }
}