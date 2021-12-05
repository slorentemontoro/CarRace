package com.example.carrace

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pl.droidsonroids.gif.GifImageView
import kotlin.random.Random

class RaceStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_race)

        var carSelectedName = carPlayerName
        var Cars = raceCars
        var Circuit = raceCircuit
        var winner = findViewById<TextView>(R.id.winner)
        var winnerImage = findViewById<GifImageView>(R.id.winnerImage)

        var Bowser = findViewById<SeekBar>(R.id.Bowser)
        var Peach = findViewById<SeekBar>(R.id.Peach)
        var DK = findViewById<SeekBar>(R.id.DK)
        var Mario = findViewById<SeekBar>(R.id.Mario)
        var Luigi = findViewById<SeekBar>(R.id.Luigi)


        fun setStyle(){
            Bowser.max = Circuit.Distance
            Peach.max = Circuit.Distance
            DK.max = Circuit.Distance
            Mario.max = Circuit.Distance
            Luigi.max = Circuit.Distance


            Bowser.progress = bowserCar.Distance
            Peach.progress = peachCar.Distance
            DK.progress = donkeyCar.Distance
            Mario.progress = marioCar.Distance
            Luigi.progress = luigiCar.Distance
        }

        var continuar = true;

        while (continuar == true){
            setStyle()
            Cars.forEach{
                it.accelerate()
                it.move()
                it.overturn()
                it.boost()

                if (it.Distance >= Circuit.Distance){
                    continuar = false
                    if (it.name == carSelectedName){
                        winner.text = "You are the winner. Congratulations!!!"
                        winnerImage.setImageResource(it.Image)
                    }else{
                        winner.text = "The Winner is "+ it.name+ ". Good luck next time :)"
                        winnerImage.setImageResource(it.Image)
                    }

                }
            }
        }
    }
}