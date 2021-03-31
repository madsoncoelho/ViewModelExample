package com.example.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var tvCounter: EditText
    lateinit var btnData: Button
    lateinit var btnShow: Button
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initClick()
    }

    private fun initData() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        tvCounter = findViewById(R.id.tvCounter)
        btnData = findViewById(R.id.btnData)
        btnShow = findViewById(R.id.btnShow)

        mainViewModel.mldCounter.observe(this, Observer { value ->
            tvCounter.setText(value)
        })
    }

    private fun initClick() {
        btnData.setOnClickListener {
            mainViewModel.incrementCounter()
        }

        btnShow.setOnClickListener {
            Toast.makeText(applicationContext, "Contador: ${mainViewModel.mldCounter.value}", Toast.LENGTH_SHORT).show()
        }
    }
}