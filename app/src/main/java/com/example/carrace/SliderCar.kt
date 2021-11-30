package com.example.carrace

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pl.droidsonroids.gif.GifImageView

class SliderCar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider_car)

        val arrayCar = mutableListOf<Cars>()
        var carGif = findViewById<GifImageView>(R.id.coches1)
        var acceleration = findViewById<ProgressBar>(R.id.accelerate)
        var maxSpeed = findViewById<ProgressBar>(R.id.maxspeed)
        var deceleration = findViewById<ProgressBar>(R.id.decelerate)
        var fuel = findViewById<ProgressBar>(R.id.fuel)
        var sw_acc = findViewById<TextView>(R.id.acceleratevalue)
        var sw_maxspeed = findViewById<TextView>(R.id.maxspeedvalue)
        var sw_dece = findViewById<TextView>(R.id.deceleratevalue)
        var sw_fuel = findViewById<TextView>(R.id.fuelvalue)
        var next_car = findViewById<ImageButton>(R.id.arrow_post)
        var previous_car = findViewById<ImageButton>(R.id.arrow_ant)


        fun mostrarcoche(coche: Cars) {
            carGif.setImageResource(coche.design)
            acceleration.progress = coche.aceleracion
            maxSpeed.progress = coche.velocidadMaxima
            deceleration.progress = coche.desaceleracion
            fuel.progress = coche.gasolina
            sw_acc.text = coche.aceleracion.toString()
            sw_dece.text = coche.desaceleracion.toString()
            sw_fuel.text = coche.gasolina.toString()
            sw_maxspeed.text = coche.velocidadMaxima.toString()
        }



        var posicion: Int = 0
        val BowserCar = Cars("Bowser", 100, 4, 10, 90, R.drawable.coche1)
        val PeachCar = Cars("Peach", 80, 10, 4, 70, R.drawable.coche2)
        val DonkeyCar = Cars("Donkey Kong", 100, 20, 10, 100, R.drawable.coche3)
        val MarioCar = Cars("Mario", 80, 10, 10, 60, R.drawable.coche4)
        val LuigiCar = Cars("Luigi", 95, 12, 8, 50, R.drawable.coche5)
        arrayCar.add(BowserCar)
        arrayCar.add(PeachCar)
        arrayCar.add(DonkeyCar)
        arrayCar.add(MarioCar)
        arrayCar.add(LuigiCar)


        acceleration.max = 30
        maxSpeed.max = 100
        deceleration.max = 30
        fuel.max = 100
        mostrarcoche(arrayCar[posicion])



        next_car.setOnClickListener {
            posicion++
            if (posicion < arrayCar.size) {
                mostrarcoche(arrayCar[posicion])
            } else {
                posicion = 0
                mostrarcoche(arrayCar[posicion])
            }
        }
        previous_car.setOnClickListener {
            posicion--
            if (posicion < 0) {
                posicion = arrayCar.size - 1
                mostrarcoche(arrayCar[posicion])
            } else {
                mostrarcoche(arrayCar[posicion])
            }
        }
    }
}