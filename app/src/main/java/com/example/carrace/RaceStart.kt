package com.example.carrace

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RaceStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_race)




        var name = findViewById<TextView>(R.id.name)

        name.text = racePlayer



    }
}