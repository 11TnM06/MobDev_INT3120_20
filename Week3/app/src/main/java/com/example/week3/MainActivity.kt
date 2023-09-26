package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var contextMenuInfo: AdapterView.AdapterContextMenuInfo
    private lateinit var textView: TextView
    private lateinit var relativeLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item1 -> {
                // Handle the click on "Exercise 1" menu item
                val intent = Intent(this, Ex1Activity::class.java)
                startActivity(intent)
                return true
            }

            R.id.menu_item2 -> {
                // Handle the click on "Exercise 2" menu item
                val intent = Intent(this, Ex2Activity::class.java)
                startActivity(intent)
                return true
            }

            R.id.menu_item3 -> {
                // Handle the click on "Exercise 3" menu item
                val intent = Intent(this, Ex3Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item4 -> {
                // Handle the click on "Exercise 3" menu item
                val intent = Intent(this, Ex4Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item5 -> {
                // Handle the click on "Exercise 3" menu item
                val intent = Intent(this, Ex5Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item6 -> {
                val intent = Intent(this, Ex6Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item7 -> {
                // Handle the click on "Exercise 3" menu item
                val intent = Intent(this, Ex7Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item8 -> {
                val intent = Intent(this, Ex8Activity::class.java)
                startActivity(intent)
                return true
            }

            R.id.menu_item9 -> {
                // Handle the click on "Exercise 3" menu item
                val intent = Intent(this, Ex9Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item10 -> {
                val intent = Intent(this, Ex10Activity::class.java)
                startActivity(intent)
                return true
            }

            R.id.menu_item11 -> {
                // Handle the click on "Exercise 3" menu item
                val intent = Intent(this, Ex11Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item12 -> {
                val intent = Intent(this, Ex12Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item13 -> {
                // Handle the click on "Exercise 3" menu item
                val intent = Intent(this, Ex13Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item14 -> {
                val intent = Intent(this, Ex14Activity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_item15 -> {
                val intent = Intent(this, Ex15Activity::class.java)
                startActivity(intent)
                return true
            }


            else -> return super.onOptionsItemSelected(item)
        }
    }
}