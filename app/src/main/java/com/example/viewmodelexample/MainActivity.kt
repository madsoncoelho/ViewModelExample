package com.example.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var tvCounter: EditText
    lateinit var btnData: Button
    lateinit var btnShow: Button

    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initCounter()
        initClick()

        validateCounter()
    }

    private fun validateCounter() {
        if (counter > 5) {
            counter = 0
        }
    }

    private fun initData() {
        tvCounter = findViewById(R.id.tvCounter)
        btnData = findViewById(R.id.btnData)
        btnShow = findViewById(R.id.btnShow)
    }

    private fun initCounter() {
        tvCounter.setText(counter.toString())
    }

    private fun initClick() {
        btnData.setOnClickListener {
            counter++
            validateCounter()
            initCounter()
        }

        btnShow.setOnClickListener {
            Toast.makeText(this, "Contador: ${counter.toString()}", Toast.LENGTH_SHORT).show()
        }
    }
}