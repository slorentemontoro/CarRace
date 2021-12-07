package com.example.carrace

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.os.Looper




class RaceStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_race)

        var Cars = raceCars
        var Circuit = raceCircuit
        var Bowser = findViewById<SeekBar>(R.id.Bowser)
        var Peach = findViewById<SeekBar>(R.id.Peach)
        var DK = findViewById<SeekBar>(R.id.DK)
        var Mario = findViewById<SeekBar>(R.id.Mario)
        var Luigi = findViewById<SeekBar>(R.id.Luigi)
        var winnertext = findViewById<TextView>(R.id.winner)
        var winnerImage = findViewById<ImageView>(R.id.winnerImage)


        fun setStyle(){
            Bowser.max = Circuit.Distance
            Peach.max = Circuit.Distance
            DK.max = Circuit.Distance
            Mario.max = Circuit.Distance
            Luigi.max = Circuit.Distance
        }


        var continuar = true



        Thread(Runnable {
        while (continuar == true){
            setStyle()
            Cars.forEach{

                print(it.name + "\n")
                it.accelerate()
                it.move()
                it.overturn()
                it.boost()
                println(it.Distance)



                Bowser.progress = bowserCar.Distance
                Peach.progress = peachCar.Distance
                DK.progress = donkeyCar.Distance
                Mario.progress = marioCar.Distance
                Luigi.progress = luigiCar.Distance
                Thread.sleep(100)


                if (it.Distance >= Circuit.Distance){
                    continuar = false


                    if (it.name == carPlayerName) {
                        winnertext.text = "You are the winner. Congratulations!!!"
                    } else {
                        winnertext.text = "The Winner is " + it.name + ". Good luck next time :)"
                    }
                    winnerImage.setImageResource(it.Image)
                }
            }
        }


        }).start()
    }
}