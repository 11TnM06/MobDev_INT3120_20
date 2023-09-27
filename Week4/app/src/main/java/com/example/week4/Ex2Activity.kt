package com.example.week4

import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ex2Activity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)

        textView = findViewById(R.id.textView)
        registerForContextMenu(textView);
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.context_item1 -> {
                // Handle Context Item 1
                textView.text = "Context Item 1 clicked for"
                return true
            }
            R.id.context_item2 -> {
                // Handle Context Item 2
                textView.text = "Context Item 2 clicked for"
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }

}