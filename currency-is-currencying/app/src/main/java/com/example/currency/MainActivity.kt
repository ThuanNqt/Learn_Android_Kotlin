package com.example.currency

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val items: Array<String> =
            arrayOf("China - Yuan", "Europe - Euro", "United States - Dollar", "Vietnam - Dong")

        val ratio = mapOf(
            "China - Yuan" to 7.13,
            "Europe - Euro" to 0.92,
            "United States - Dollar" to 1.0,
            "Vietnam - Dong" to 25.345
        )

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            items
        )

        val upperSpinner: Spinner = findViewById(R.id.input_spinner)
        val upperEditText: EditText = findViewById(R.id.input)
        var upperType = ""
        val lowerSpinner: Spinner = findViewById(R.id.output_spinner)
        val lowerEditText: EditText = findViewById(R.id.output)
        var lowerType = ""

        upperSpinner.adapter = arrayAdapter
        lowerSpinner.adapter = arrayAdapter

        upperSpinner.onItemSelectedListener =
            object : OnItemSelectedListener, AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    upperType = items[p2]
                    upperEditText.setText("")
                    lowerEditText.setText("0")
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    upperType = items[0]
                }

                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    TODO("Not yet implemented")
                }
            }

        lowerSpinner.onItemSelectedListener =
            object : OnItemSelectedListener, AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    lowerType = items[p2]
                    lowerEditText.setText("")
                    upperEditText.setText("0")
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    lowerType = items[0]
                }

                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    TODO("Not yet implemented")
                }
            }

        upperEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                upperEditText.setText("")
                lowerEditText.setText("0")
            }
        }

        lowerEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                lowerEditText.setText("")
                upperEditText.setText("0")
            }
        }

        upperEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (upperEditText.isFocused) {
                    if (p0 != null) {
                        if (p0.isNotEmpty()) {
                            val input = p0.toString().toDouble()
                            val inputRatio = ratio[upperType] ?: 0.0
                            val outputRatio = ratio[lowerType] ?: 1.0
                            val output = (input * outputRatio) / inputRatio
                            lowerEditText.setText("$output")
                        }
                    }
                }
            }
        })

        lowerEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (lowerEditText.isFocused) {
                    if (p0 != null) {
                        if (p0.isNotEmpty()) {
                            val input = p0.toString().toDouble()
                            val inputRatio = ratio[lowerType] ?: 0.0
                            val outputRatio = ratio[upperType] ?: 1.0
                            val output = (input * outputRatio) / inputRatio
                            upperEditText.setText("$output")
                        }
                    }
                }
            }
        })
    }
}