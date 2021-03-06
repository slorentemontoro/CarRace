package com.example.carrace

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import pl.droidsonroids.gif.GifImageView
import kotlin.properties.Delegates

var positionCar = 0
val arrayCar = mutableListOf<Cars>()

val bowserCar = Cars("Bowser",0, 100, 4,2, R.drawable.coche1,0)
val peachCar = Cars("Peach",0, 80, 10,4, R.drawable.coche2,0)
val donkeyCar = Cars("Donkey Kong",0, 100, 20,1, R.drawable.coche3,0)
val marioCar = Cars("Mario",0, 80, 10,5, R.drawable.coche4,0)
val luigiCar = Cars("Luigi",0, 95, 12,3, R.drawable.coche5,0)

lateinit var carPlayerName: String
val raceCars = arrayCar



class SelectCar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_car)


        val carGif = findViewById<GifImageView>(R.id.car)
        val name = findViewById<TextView>(R.id.name)
        val acceleration = findViewById<ProgressBar>(R.id.accelerate)
        val maxSpeed = findViewById<ProgressBar>(R.id.maxspeed)
        val stability = findViewById<RatingBar>(R.id.stability)
        val swacc = findViewById<TextView>(R.id.accelerationvalue)
        val swmaxspeed = findViewById<TextView>(R.id.maxSpeedvalue)
        val nextcar = findViewById<ImageButton>(R.id.arrow_post)
        val previouscar = findViewById<ImageButton>(R.id.arrow_ant)
        val select = findViewById<Button>(R.id.next)


        val distance = findViewById<TextView>(R.id.textView6)
        val bundle = intent.extras
        distance.text = bundle?.getInt("Circuit").toString()

        fun showCar(coche: Cars) {
            carGif.setImageResource(coche.Image)
            acceleration.progress = coche.accelerate
            maxSpeed.progress = coche.maxSpeed
            stability.rating = coche.stability.toFloat()
            name.text = coche.name
            swacc.text = coche.accelerate.toString()
            swmaxspeed.text = coche.maxSpeed.toString()
        }






        arrayCar.add(bowserCar)
        arrayCar.add(peachCar)
        arrayCar.add(donkeyCar)
        arrayCar.add(marioCar)
        arrayCar.add(luigiCar)



        showCar(arrayCar[positionCar])

        nextcar.setOnClickListener {
            positionCar++
            if (positionCar < arrayCar.size) {
                showCar(arrayCar[positionCar])
            } else {
                positionCar = 0
                showCar(arrayCar[positionCar])
            }
        }
        previouscar.setOnClickListener {
            positionCar--
            if (positionCar < 0) {
                positionCar = arrayCar.size - 1
                showCar(arrayCar[positionCar])
            } else {
                showCar(arrayCar[positionCar])
            }
        }
        select.setOnClickListener {
            val cambiando = Intent(this, RaceStart::class.java)
            carPlayerName = arrayCar[positionCar].name
            startActivity(cambiando)
        }
    }
}
