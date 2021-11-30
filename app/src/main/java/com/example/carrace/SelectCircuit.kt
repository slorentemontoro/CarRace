package com.example.carrace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class SelectCircuit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_circuit)


        val arrayCircuit = mutableListOf<Circuit>()
        val circuit = findViewById<ImageButton>(R.id.circuit)
        val name = findViewById<TextView>(R.id.name)
        val next_circuit = findViewById<ImageButton>(R.id.arrow_post)
        val previous_circuit = findViewById<ImageButton>(R.id.arrow_ant)
        val next = findViewById<Button>(R.id.next)


        fun mostrarcircuit(coche: Circuit) {
            name.text = coche.nombre
            circuit.setImageResource(coche.image)
        }



        var posicion = 0
        val circuit1 = Circuit("Isla Choco", R.drawable.circuito1)
        val circuit2 = Circuit("Playa Koopa", R.drawable.circuito2)
        val circuit3 = Circuit("Castillo de Bowser", R.drawable.circuito3)
        val circuit4 = Circuit("Prado Rosquilla", R.drawable.circuito4)
        val circuit5 = Circuit("Valle Fantasma", R.drawable.circuito5)


        arrayCircuit.add(circuit1)
        arrayCircuit.add(circuit2)
        arrayCircuit.add(circuit3)
        arrayCircuit.add(circuit4)
        arrayCircuit.add(circuit5)

        mostrarcircuit(arrayCircuit[posicion])



        next_circuit.setOnClickListener {
            posicion++
            if (posicion < arrayCircuit.size) {
                mostrarcircuit(arrayCircuit[posicion])
            } else {
                posicion = 0
                mostrarcircuit(arrayCircuit[posicion])
            }
        }
        previous_circuit.setOnClickListener {
            posicion--
            if (posicion < 0) {
                posicion = arrayCircuit.size - 1
                mostrarcircuit(arrayCircuit[posicion])
            } else {
                mostrarcircuit(arrayCircuit[posicion])
            }
        }

    }
}