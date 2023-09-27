package com.example.week4

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ex3Activity : AppCompatActivity() {

    private lateinit var popupButton : Button
    private lateinit var anchorButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3)

        popupButton = findViewById(R.id.popup_button)
        anchorButton = findViewById(R.id.anchor_button)
        val popupMenu = PopupMenu(this, anchorButton, Gravity.END)
        popupButton.setOnClickListener { v ->
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.action_item1 -> {
                        // Handle Item 1 click
                        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.action_item2 -> {
                        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                        // Handle Item 2 click
                        true
                    }

                    R.id.action_item3 -> {
                        // Handle Item 3 click
                        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }
            }

            popupMenu.show()
        }
    }
}