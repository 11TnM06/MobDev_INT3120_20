package com.example.week3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TabHost
import androidx.appcompat.app.AppCompatActivity

class Ex14Activity : AppCompatActivity() {
    private lateinit var tabs: TabHost
    private lateinit var btnEnter: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex14)

        tabs = findViewById(R.id.tabhost)
        tabs.setup()
        var spec: TabHost.TabSpec // Declare a variable spec of type TabHost.TabSpec for configuring and creating tabs.
        spec = tabs.newTabSpec("tag1") // Create a new TabSpec object with the name "tag1".
        spec.setContent(R.id.tab1) // Set the content for tab1.
        spec.setIndicator("1-Clock") // Set the title to display for tab1.
        tabs.addTab(spec) // Add the configured tab to the TabHost for display.

        spec = tabs.newTabSpec("tag2")
        spec.setContent(R.id.tab2)
        spec.setIndicator("2-Login")
        tabs.addTab(spec)

        tabs.currentTab = 0
        btnEnter = findViewById(R.id.btnEnter)
        btnEnter.setOnClickListener {
            val txtPerson = findViewById<EditText>(R.id.txtPerson)
            val theUser = txtPerson.text.toString()
            txtPerson.setText("Xin chao $theUser")
        }
    }
}

