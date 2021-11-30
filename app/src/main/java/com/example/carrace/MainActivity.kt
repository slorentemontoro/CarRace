package com.example.carrace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var menu = findViewById<ImageButton>(R.id.start);
        menu.setOnClickListener {
            val cambiando= Intent(this,Menu::class.java)
            startActivity(cambiando)
        }
    }
}