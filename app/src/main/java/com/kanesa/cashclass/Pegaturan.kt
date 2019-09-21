package com.kanesa.cashclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_pegaturan.*

class Pegaturan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pegaturan)
        setSpinner()
        close.setOnClickListener {
            keluar()
        }
    }

    private fun keluar() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun setSpinner() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.hari, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        hari.adapter = adapter
    }
}
