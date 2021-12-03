package com.example.carrace

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class RaceStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_race)

        var carSelected = carPlayer
        var Cars = raceCars
        var name = findViewById<TextView>(R.id.race)
        var winner = findViewById<TextView>(R.id.winner)

        name.text = "Has elegido al personaje:" + carSelected
        var random = Random.nextInt(1,5)

        winner.text = "The Winner is "+ Cars[random].name + ". Congratulations!!!! :)"








    }
}