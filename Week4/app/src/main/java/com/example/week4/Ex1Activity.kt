package com.example.week4

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ex1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu1, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_item1 -> {
                Toast.makeText(this, "Menu Item 1", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_item2 -> {
                Toast.makeText(this, "Menu Item 2", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_item3 -> {
                Toast.makeText(this, "Menu Item 3", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_item4 -> {
                Toast.makeText(this, "Menu Item 4", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}