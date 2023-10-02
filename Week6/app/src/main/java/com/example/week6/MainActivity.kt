package com.example.week6

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private val items = arrayOf(
        "Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5", "Exercise 6"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gv = findViewById<GridView>(R.id.gridView)

        val aa = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        gv.adapter = aa
        gv.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, v: View?, position: Int, id: Long) {
        when (position) {
            0 -> {
                val intent = Intent(this, Ex1Activity::class.java)
                startActivity(intent)
            }

            1 -> {
                val intent = Intent(this, Ex2Activity::class.java)
                startActivity(intent)
            }

            2 -> {
                val intent = Intent(this, Ex3Activity::class.java)
                startActivity(intent)
            }

            3 -> {
                val intent = Intent(this, Ex4Activity::class.java)
                startActivity(intent)
            }

            4 -> {
                val intent = Intent(this, Ex5Activity::class.java)
                startActivity(intent)
            }

        }
    }
}