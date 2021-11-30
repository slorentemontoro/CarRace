package com.example.carrace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu = findViewById<ImageButton>(R.id.start)
        menu.setOnClickListener {
            val cambiando= Intent(this,SelectCar::class.java)
            startActivity(cambiando)
        }
    }
}