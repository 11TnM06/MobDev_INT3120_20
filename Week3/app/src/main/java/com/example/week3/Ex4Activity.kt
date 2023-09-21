package com.example.week3
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class Ex4Activity : AppCompatActivity(), TextWatcher {

    private lateinit var selection: TextView
    private lateinit var edit: AutoCompleteTextView
    private val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4)

        selection = findViewById(R.id.selection)
        edit = findViewById(R.id.edit)
        edit.addTextChangedListener(this)

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items)
        edit.setAdapter(adapter)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        selection.text = edit.text.toString()
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // Implementation not needed for this example
    }

    override fun afterTextChanged(s: Editable?) {
        // Implementation not needed for this example
    }
}