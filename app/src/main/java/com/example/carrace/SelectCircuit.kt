package com.example.carrace

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

var positionCircuit = 0

var arrayCircuit = mutableListOf<Circuit>()
val circuit1 = Circuit("Isla Choco", R.drawable.circuito1, 2000)
val circuit2 = Circuit("Playa Koopa", R.drawable.circuito2, 1000)
val circuit3 = Circuit("Castillo de Bowser", R.drawable.circuito3, 1500)
val circuit4 = Circuit("Prado Rosquilla", R.drawable.circuito4, 500)
val circuit5 = Circuit("Valle Fantasma", R.drawable.circuito5, 700)


class SelectCircuit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_circuit)
   
        val circuit = findViewById<ImageButton>(R.id.circuit)
        val name = findViewById<TextView>(R.id.name)
        val nextCircuit = findViewById<ImageButton>(R.id.arrow_post)
        val previousCircuit = findViewById<ImageButton>(R.id.arrow_ant)
        val next = findViewById<Button>(R.id.next)


        fun showcircuit(coche: Circuit) {
            name.text = coche.name
            circuit.setImageResource(coche.image)
        }

        arrayCircuit.add(circuit1)
        arrayCircuit.add(circuit2)
        arrayCircuit.add(circuit3)
        arrayCircuit.add(circuit4)
        arrayCircuit.add(circuit5)


        showcircuit(arrayCircuit[positionCircuit])

        nextCircuit.setOnClickListener {
            positionCircuit++
            if (positionCircuit < arrayCircuit.size) {
                showcircuit(arrayCircuit[positionCircuit])
            } else {
                positionCircuit = 0
                showcircuit(arrayCircuit[positionCircuit])
            }
        }
        previousCircuit.setOnClickListener {
            positionCircuit--
            if (positionCircuit < 0) {
                positionCircuit = arrayCircuit.size - 1
                showcircuit(arrayCircuit[positionCircuit])
            } else {
                showcircuit(arrayCircuit[positionCircuit])
            }
        }

        next.setOnClickListener {
            val cambiando = Intent(this, SelectCar::class.java)
            startActivity(cambiando)
        }

    }
}