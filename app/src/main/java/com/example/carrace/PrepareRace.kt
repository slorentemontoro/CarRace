package com.example.carrace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PrepareRace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prepare_race)


        SelectCircuit()
    }
}