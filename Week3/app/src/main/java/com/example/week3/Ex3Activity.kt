package com.example.week3
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ex3Activity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var selection: TextView
    private val items = arrayOf(
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3)

        selection = findViewById(R.id.selection)
        val gv = findViewById<GridView>(R.id.grid)

        val aa = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        gv.adapter = aa
        gv.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, v: View?, position: Int, id: Long) {
        selection.text = items[position]
    }
}