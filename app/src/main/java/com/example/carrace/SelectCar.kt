package com.example.carrace

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pl.droidsonroids.gif.GifImageView

class SelectCar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_car)

        val arrayCar = mutableListOf<Cars>()
        val carGif = findViewById<GifImageView>(R.id.car)
        val name = findViewById<TextView>(R.id.name)
        val acceleration = findViewById<ProgressBar>(R.id.accelerate)
        val maxSpeed = findViewById<ProgressBar>(R.id.maxspeed)
        val deceleration = findViewById<ProgressBar>(R.id.decelerate)
        val fuel = findViewById<ProgressBar>(R.id.fuel)
        val swacc = findViewById<TextView>(R.id.accelerationvalue)
        val swmaxspeed = findViewById<TextView>(R.id.maxSpeedvalue)
        val swdece = findViewById<TextView>(R.id.deceleratevalue)
        val swfuel = findViewById<TextView>(R.id.fuelvalue)
        val nextcar = findViewById<ImageButton>(R.id.arrow_post)
        val previouscar = findViewById<ImageButton>(R.id.arrow_ant)
        val select = findViewById<Button>(R.id.next)


        fun showCar(coche: Cars) {
            carGif.setImageResource(coche.Image)
            acceleration.progress = coche.accelerate
            maxSpeed.progress = coche.maxSpeed
            deceleration.progress = coche.brake
            fuel.progress = coche.fuel
            name.text = coche.name
            swacc.text = coche.accelerate.toString()
            swdece.text = coche.brake.toString()
            swfuel.text = coche.fuel.toString()
            swmaxspeed.text = coche.maxSpeed.toString()
        }



        var position = 0
        
        val bowserCar = Cars("Bowser", 100, 4, 10, 90, R.drawable.coche1)
        val peachCar = Cars("Peach", 80, 10, 4, 70, R.drawable.coche2)
        val donkeyCar = Cars("Donkey Kong", 100, 20, 10, 100, R.drawable.coche3)
        val marioCar = Cars("Mario", 80, 10, 10, 60, R.drawable.coche4)
        val luigiCar = Cars("Luigi", 95, 12, 8, 50, R.drawable.coche5)


        arrayCar.add(bowserCar)
        arrayCar.add(peachCar)
        arrayCar.add(donkeyCar)
        arrayCar.add(marioCar)
        arrayCar.add(luigiCar)

        showCar(arrayCar[position])

        nextcar.setOnClickListener {
            position++
            if (position < arrayCar.size) {
                showCar(arrayCar[position])
            } else {
                position = 0
                showCar(arrayCar[position])
            }
        }
        previouscar.setOnClickListener {
            position--
            if (position < 0) {
                position = arrayCar.size - 1
                showCar(arrayCar[position])
            } else {
                showCar(arrayCar[position])
            }
        }




    }
}