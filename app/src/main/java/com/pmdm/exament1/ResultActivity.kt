package com.pmdm.exament1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initComponents()
        initUI()
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
    }

    private fun setResult() {
        var chairs = intent.extras?.getString("EXTRA_CHAIRS").orEmpty()
        var name = intent.extras?.getString("EXTRA_NAME").orEmpty()
        var time = intent.extras?.getString("EXTRA_TIME").orEmpty()

        tvResult.text = "Mesa reservada para $chairs personas a nombre de $name, a las $time:00"
    }

    private fun initUI() {
        setResult()
    }
}