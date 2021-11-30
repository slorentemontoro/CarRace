package com.example.carrace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class SliderCar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider_car)

        val ArrayCoches= mutableListOf<Cars>();
        var fondo_coche=findViewById<ImageView>(R.id.paisaje)
        var gifcoche=findViewById<GifImageView>(R.id.coches1)
        var aceleracion=findViewById<ProgressBar>(R.id.accelerate)
        var velocidadMaxima=findViewById<ProgressBar>(R.id.maxspeed)
        var desaceleracion=findViewById<ProgressBar>(R.id.decelerate)
        var gasolina=findViewById<ProgressBar>(R.id.fuel)
        var sw_acc=findViewById<TextView>(R.id.acceleratevalue)
        var sw_vmax=findViewById<TextView>(R.id.maxspeedvalue)
        var sw_desc=findViewById<TextView>(R.id.deceleratevalue)
        var sw_gas=findViewById<TextView>(R.id.fuelvalue)
        var next_car=findViewById<ImageButton>(R.id.arrow_post)
        var previous_car=findViewById<ImageButton>(R.id.arrow_ant)
        fun mostrarcoche(coche:Cars){
            fondo_coche.setImageResource(coche.fondo)
            sw_acc.setText(coche.aceleracion.toString())
            sw_desc.setText(coche.desaceleracion.toString())
            sw_gas.setText(coche.gasolina.toString())
            sw_vmax.setText(coche.velocidadMaxima.toString())
            gifcoche.setImageResource(coche.design)
            velocidadMaxima.setProgress(coche.velocidadMaxima)
            aceleracion.setProgress(coche.aceleracion)
            desaceleracion.setProgress(coche.desaceleracion)
            gasolina.setProgress(coche.gasolina)
        }

        var posicion :Int=0
        val coche1=Cars("octane",70,6,3,90,R.drawable.coche1,R.drawable.fondo1)
        val coche2=Cars("octane V2",80,5,6,75,R.drawable.coche2,R.drawable.fondo2)
        val coche3=Cars("lorean",100,8,6,60,R.drawable.coche3,R.drawable.fondo3)
        val coche4=Cars("bearch",85,10,5,75,R.drawable.coche4,R.drawable.fondo4)
        val coche5=Cars("Rayo Mcqueen",95,12,8,50,R.drawable.coche5,R.drawable.fondo5)
        ArrayCoches.add(coche1)
        ArrayCoches.add(coche2)
        ArrayCoches.add(coche3)
        ArrayCoches.add(coche4)
        ArrayCoches.add(coche5)


        aceleracion.max=30
        velocidadMaxima.max=100
        desaceleracion.max=30
        gasolina.max=100
        mostrarcoche(ArrayCoches[posicion])



        next_car.setOnClickListener {
            posicion++;
            if (posicion<ArrayCoches.size){
                mostrarcoche(ArrayCoches[posicion])
            }else{
                posicion=0;
                mostrarcoche(ArrayCoches[posicion])
            }
        }
        previous_car.setOnClickListener {
            posicion--;
            if(posicion<0){
                posicion=ArrayCoches.size-1
                mostrarcoche(ArrayCoches[posicion])
            }else{
                mostrarcoche(ArrayCoches[posicion])
            }
        }
    }
}