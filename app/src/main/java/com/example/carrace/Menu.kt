package com.example.carrace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        var slider = findViewById<ImageButton>(R.id.slider);
        slider.setOnClickListener {
            val cambiando = Intent(this,SliderCar::class.java)
            startActivity(cambiando)
        }
    }
}