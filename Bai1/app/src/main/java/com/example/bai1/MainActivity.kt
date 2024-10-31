package com.example.bai1
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber: EditText = findViewById(R.id.textViewNumber)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val btnShow: Button = findViewById(R.id.btnShow)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val textViewMessage: TextView = findViewById(R.id.textViewMessage)

        recyclerView.layoutManager = LinearLayoutManager(this)

        btnShow.setOnClickListener {
            val inputText = editTextNumber.text.toString()
            val selectedRadioId = radioGroup.checkedRadioButtonId
            val numberList = mutableListOf<Int>()

            if (inputText.isNotEmpty()) {
                val n = inputText.toInt()
                when (selectedRadioId) {
                    R.id.radioEven -> {
                        for (i in 0..n step 2) {
                            numberList.add(i)
                        }
                    }
                    R.id.radioOdd -> {
                        for (i in 1..n step 2) {
                            numberList.add(i)
                        }
                    }
                    R.id.radioSquare -> {
                        var i = 0
                        while (i * i <= n) {
                            numberList.add(i * i)
                            i++
                        }
                    }
                    else -> {
                        textViewMessage.text = "Please select a number type"
                        return@setOnClickListener
                    }
                }
                textViewMessage.text = ""
                recyclerView.adapter = NumberAdapter(numberList)
            } else {
                textViewMessage.text = "Please enter a valid number"
            }
        }
    }
}
