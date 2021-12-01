package com.example.carrace

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SelectCircuit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_circuit)


        val arrayCircuit = mutableListOf<Circuit>()
        val circuit = findViewById<ImageButton>(R.id.circuit)
        val name = findViewById<TextView>(R.id.name)
        val nextCircuit = findViewById<ImageButton>(R.id.arrow_post)
        val previousCircuit = findViewById<ImageButton>(R.id.arrow_ant)
        val next = findViewById<Button>(R.id.next)


        fun showcircuit(coche: Circuit) {
            name.text = coche.nombre
            circuit.setImageResource(coche.image)
        }



        var position = 0

            val circuit1 = Circuit("Isla Choco", R.drawable.circuito1, 2000)
            val circuit2 = Circuit("Playa Koopa", R.drawable.circuito2, 1000)
            val circuit3 = Circuit("Castillo de Bowser", R.drawable.circuito3, 1500)
            val circuit4 = Circuit("Prado Rosquilla", R.drawable.circuito4, 500)
            val circuit5 = Circuit("Valle Fantasma", R.drawable.circuito5, 700)

            arrayCircuit.add(circuit1)
            arrayCircuit.add(circuit2)
            arrayCircuit.add(circuit3)
            arrayCircuit.add(circuit4)
            arrayCircuit.add(circuit5)




        showcircuit(arrayCircuit[position])

        nextCircuit.setOnClickListener {
            position++
            if (position < arrayCircuit.size) {
                showcircuit(arrayCircuit[position])
            } else {
                position = 0
                showcircuit(arrayCircuit[position])
            }
        }
        previousCircuit.setOnClickListener {
            position--
            if (position < 0) {
                position = arrayCircuit.size - 1
                showcircuit(arrayCircuit[position])
            } else {
                showcircuit(arrayCircuit[position])
            }
        }

        next.setOnClickListener {
            val cambiando= Intent(this,SelectCar::class.java)
            val pista = Circuit(arrayCircuit[position].nombre, arrayCircuit[position].image, arrayCircuit[position].Distance)
            startActivity(cambiando)

        }

    }
}